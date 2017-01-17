package org.mk300.brms.perf;

public interface Consts {
    public static long execTimeSec = 10;
    public static int threadNum = Math.max(1, Runtime.getRuntime().availableProcessors() - 1);
//    public static int threadNum = 1;

}
