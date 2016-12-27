package org.mk300.brms.perf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerfCounter implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(PerfCounter.class);
    private volatile boolean running = true;

    private String name;

    private final List<AtomicLong> counterList = new ArrayList<AtomicLong>();
    private final ThreadLocal<AtomicLong> localCounter = new ThreadLocal<AtomicLong>();

    public PerfCounter(String name) {
        this.name = name;
    }

    public void increment() {
        AtomicLong lc = localCounter.get();
        if (lc == null) {
            lc = new AtomicLong();
            localCounter.set(lc);
            synchronized (counterList) {
                counterList.add(lc);
            }
        }
        lc.incrementAndGet();
    }

    @Override
    public void run() {
        long preCount = 0;
        long preTime = System.currentTimeMillis();
        while (running) {
            try {
                long nowTime = System.currentTimeMillis();
                long nowCount = 0;

                synchronized (counterList) {
                    for (AtomicLong l : counterList) {
                        nowCount += l.get();
                    }
                }

                double perSec = ((double) (nowCount - preCount)) / (nowTime - preTime) * 1000;

                log.info(String.format("%s : %,d tx/sec", name, (long) perSec));

                preCount = nowCount;
                preTime = nowTime;

                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
    }

    public void stop() {
        running = false;
    }
}
