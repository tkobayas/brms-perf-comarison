package org.mk300.brms.perf;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.internal.builder.conf.RuleEngineOption;

public class ReteOO_Accumulate {

    private static RuleBase ruleBase;

    @BeforeClass
    public static void init() {
        ruleBase = new RuleBase("src/test/resources/rule2", RuleEngineOption.RETEOO);
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ruleBase.disposeAll();
    }
    

    @Test
    public void test() throws Exception {
        PerfRunner perfRunner = new PerfRunner(Consts.threadNum, ruleBase, Consts.execTimeSec, this.getClass().getSimpleName());
        perfRunner.doExec();
    }
}
