package org.mk300.brms.perf;

import java.io.File;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message.Level;
import org.kie.api.builder.ReleaseId;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.conf.RuleEngineOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleBase {
    private static final Logger logger = LoggerFactory.getLogger(RuleBase.class);

    private KieBase kBase;
    private ConcurrentLinkedQueue<KieSession> pool;
    private ReleaseId releaseId;

    public RuleBase(String ruleDir, RuleEngineOption option) {
        logger.info("##################### RuleBase start ");
        try {

            pool = new ConcurrentLinkedQueue<>();
            kBase = createNewKBase(ruleDir, option);

            if (kBase == null) {
                throw new RuntimeException("rule build error.");
            }

            logKBase(kBase);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private KieBase createNewKBase(String ruleDir, RuleEngineOption option) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();

        KieRepository kr = kieServices.getRepository();
        releaseId = kr.getDefaultReleaseId();

        File ruleBaseDirFile = new File(ruleDir);
        writeAllRule(kfs, ruleBaseDirFile);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        if (kieBuilder.getResults().getMessages(Level.WARNING).size() > 0) {
            logger.warn("kieBuilder warn!: {}", kieBuilder.getResults().getMessages(Level.WARNING));
        }
        if (kieBuilder.getResults().getMessages(Level.ERROR).size() > 0) {
            logger.error("kieBuilder error!: {}", kieBuilder.getResults().getMessages(Level.ERROR));
            return null;
        }

        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
        KieBaseConfiguration kconfig = kieServices.newKieBaseConfiguration();
        kconfig.setOption(option);
        return kieContainer.newKieBase(kconfig);
    }

    private void writeAllRule(KieFileSystem kfs, File file) {
        if (!file.exists() || file.isHidden()) {
            return;
        }

        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                writeAllRule(kfs, subFile);
            }
            return;
        }

        if (file.canRead()) {
            KieServices kieServices = KieServices.Factory.get();
            String fullPath = file.getAbsolutePath();

            if (File.separator.equals("\\")) {
                // For Windows Platform
                fullPath = fullPath.replaceAll("\\\\", "/");
            }

            kfs.write("src/main/resources/" + fullPath,
                    kieServices.getResources().newFileSystemResource(fullPath, "UTF-8"));

        }
    }

    public void disposeAll() {
        logger.debug("##################### disposeAll start ");

        while (true) {
            KieSession session = pool.poll();
            if (session == null) {
                break;
            } else {
                session.dispose();
                logger.debug("destory() Dispose RuleSession {}", session);
            }
        }

        KieServices.Factory.get().getRepository().removeKieModule(releaseId);

        logger.info("##################### disposeAll end ");
    }

    private void logKBase(KieBase kbase) {
        logger.debug(" kbase = {}", kbase);

        Collection<KiePackage> packages = kbase.getKiePackages();

        for (KiePackage pkg : packages) {
            logger.debug("  pkg = {}", pkg);

            Collection<Rule> rules = pkg.getRules();
            for (Rule rule : rules) {
                logger.debug("   rule = {}", rule.getName());
            }
        }
    }

    public KieSession borrow() {
        KieSession session = pool.poll();

        if (session == null) {
            session = kBase.newKieSession();
            logger.debug("borrow() New RuleSession {}", session);
        }
        return session;
    }

    public void release(KieSession session) {
        if (session == null) {
            return;
        }

//        for (FactHandle fh : session.getFactHandles()) {
//            session.delete(fh);
//        }

        pool.offer(session);
    }
}
