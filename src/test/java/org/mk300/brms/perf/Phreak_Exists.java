package org.mk300.brms.perf;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.internal.builder.conf.RuleEngineOption;

public class Phreak_Exists {

    private static RuleBase ruleBase;

    @BeforeClass
    public static void init() {
        ruleBase = new RuleBase("src/test/resources/rule1", RuleEngineOption.PHREAK);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ruleBase.disposeAll();
    }

    @Test
    public void test() throws Exception {
        PerfRunner perfRunner = new PerfRunner(Consts.threadNum, ruleBase, Consts.execTimeSec,
                this.getClass().getSimpleName());
        perfRunner.doExec();
    }
}
