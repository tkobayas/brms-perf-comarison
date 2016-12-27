package org.mk300.brms.perf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.kie.api.runtime.KieSession;
import org.mk300.brms.perf.facts.MyFact1;
import org.mk300.brms.perf.facts.MyFact2;
import org.mk300.brms.perf.facts.MyFact3;
import org.mk300.brms.perf.facts.MyFact4;
import org.mk300.brms.perf.facts.MyFact5;
import org.mk300.brms.perf.functions.MyFunction;

public class PerfRunner {

    private int threadNum;
    private long execTimeSec;
    
    private final RuleBase ruleBase;
    private final PerfCounter counter;
    
    private volatile boolean running = true;
    
    public PerfRunner(int threadNum, RuleBase ruleBase, long execTimeSec, String perfName) {
        this.threadNum = threadNum;
        this.ruleBase = ruleBase;
        this.execTimeSec = execTimeSec;
        counter = new PerfCounter(perfName);
    }
    
    public void doExec() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum+1);
        
        executorService.execute(counter);
        for(int i=0; i<threadNum ; i++) {
            executorService.execute(new Runner());
        }
        
        Thread.sleep(TimeUnit.SECONDS.toMillis(execTimeSec));
        running = false;
        counter.stop();
        
        executorService.shutdown();
        
    }

    
    class Runner implements Runnable {
        @Override
        public void run() {
            while(running){

                KieSession session = null;
                try {
                    session = ruleBase.borrow();
                    
                    final MyFunction result = new MyFunction();
                    session.setGlobal("result", result);
                    

                    MyFact1 fact1 = new MyFact1();
                    fact1.setId("hoge");
                    fact1.setValue1("hoge1");
                    fact1.setValue2("hoge2");
                    fact1.setValue3("hoge3");
                    fact1.setValue4("hoge4");
                    fact1.setValue5("hoge5");
                    
                    MyFact2 fact2 = new MyFact2();
                    fact2.setId("hoge");
                    fact2.setValue1("hoge1");
                    fact2.setValue2("hoge2");
                    fact2.setValue3("hoge3");
                    fact2.setValue4("hoge4");
                    fact2.setValue5("hoge5");
                    
                    MyFact3 fact3 = new MyFact3();
                    fact3.setId("hoge");
                    fact3.setValue1("hoge1");
                    fact3.setValue2("hoge2");
                    fact3.setValue3("hoge3");
                    fact3.setValue4("hoge4");
                    fact3.setValue5("hoge5");
                    
                    MyFact4 fact4 = new MyFact4();
                    fact4.setId("hoge");
                    fact4.setValue1("hoge1");
                    fact4.setValue2("hoge2");
                    fact4.setValue3("hoge3");
                    fact4.setValue4("hoge4");
                    fact4.setValue5("hoge5");
                    
                    MyFact5 fact5 = new MyFact5();
                    fact5.setId("hoge");
                    fact5.setValue1("hoge1");
                    fact5.setValue2("hoge2");
                    fact5.setValue3("hoge3");
                    fact5.setValue4("hoge4");
                    fact5.setValue5("hoge5");

                    
                    session.insert(fact1);
                    session.insert(fact2);
                    session.insert(fact3);
                    session.insert(fact4);
                    session.insert(fact5);
                    
                    session.fireAllRules();
                    
                } finally {
                    ruleBase.release(session);
                }
                
                counter.increment();
            }
        }
        
    }
}
