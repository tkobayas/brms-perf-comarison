# brms-perf-comarison

### run with BRMS 6.0.3.GA

`mvn -P BRMS603GA clean test`

### Run with BMRS 6.4.0.GA

`mvn -P BRMS640GA clean test`

## Output example(Run with BMRS 6.4.0.GA)

```
Running org.mk300.brms.perf.Phreak_Accumulate
2016-12-27 16:51:40,280 INFO  (main) [RuleBase] ##################### RuleBase start
2016-12-27 16:51:42,322 INFO  (main) [KieRepositoryImpl] KieModule was added: MemoryKieModule[releaseId=org.default:artifact:1.0.0-SNAPSHOT]
2016-12-27 16:51:42,519 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 0 tx/sec
2016-12-27 16:51:43,529 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 29,020 tx/sec
2016-12-27 16:51:44,533 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 159,216 tx/sec
2016-12-27 16:51:45,539 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 203,391 tx/sec
2016-12-27 16:51:46,539 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 202,453 tx/sec
2016-12-27 16:51:47,553 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 204,160 tx/sec
2016-12-27 16:51:48,555 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 199,914 tx/sec
2016-12-27 16:51:49,556 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 193,496 tx/sec
2016-12-27 16:51:50,557 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 200,377 tx/sec
2016-12-27 16:51:51,557 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Accumulate : 202,060 tx/sec
2016-12-27 16:51:52,522 INFO  (main) [RuleBase] ##################### disposeAll end
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.394 sec - in org.mk300.brms.perf.Phreak_Accumulate
Running org.mk300.brms.perf.Phreak_Exists
2016-12-27 16:51:52,860 INFO  (main) [RuleBase] ##################### RuleBase start
2016-12-27 16:51:54,521 INFO  (main) [KieRepositoryImpl] KieModule was added: MemoryKieModule[releaseId=org.default:artifact:1.0.0-SNAPSHOT]
2016-12-27 16:51:54,716 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 0 tx/sec
2016-12-27 16:51:55,737 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 72,411 tx/sec
2016-12-27 16:51:56,737 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 257,065 tx/sec
2016-12-27 16:51:57,741 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 292,136 tx/sec
2016-12-27 16:51:58,746 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 283,862 tx/sec
2016-12-27 16:51:59,753 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 285,201 tx/sec
2016-12-27 16:52:00,753 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 290,762 tx/sec
2016-12-27 16:52:01,760 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 291,661 tx/sec
2016-12-27 16:52:02,760 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 296,011 tx/sec
2016-12-27 16:52:03,767 INFO  (pool-1-thread-1) [PerfCounter] Phreak_Exists : 296,844 tx/sec
2016-12-27 16:52:04,719 INFO  (main) [RuleBase] ##################### disposeAll end
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.004 sec - in org.mk300.brms.perf.Phreak_Exists
Running org.mk300.brms.perf.ReteOO_Accumulate
2016-12-27 16:52:05,068 INFO  (main) [RuleBase] ##################### RuleBase start
2016-12-27 16:52:07,139 INFO  (main) [KieRepositoryImpl] KieModule was added: MemoryKieModule[releaseId=org.default:artifact:1.0.0-SNAPSHOT]
2016-12-27 16:52:07,349 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 0 tx/sec
2016-12-27 16:52:08,368 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 50,996 tx/sec
2016-12-27 16:52:09,380 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 217,269 tx/sec
2016-12-27 16:52:10,391 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 252,807 tx/sec
2016-12-27 16:52:11,453 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 245,798 tx/sec
2016-12-27 16:52:12,457 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 225,747 tx/sec
2016-12-27 16:52:13,458 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 254,959 tx/sec
2016-12-27 16:52:14,487 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 249,093 tx/sec
2016-12-27 16:52:15,496 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 237,899 tx/sec
2016-12-27 16:52:16,517 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Accumulate : 237,790 tx/sec
2016-12-27 16:52:17,375 INFO  (main) [RuleBase] ##################### disposeAll end
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.455 sec - in org.mk300.brms.perf.ReteOO_Accumulate
Running org.mk300.brms.perf.ReteOO_Exists
2016-12-27 16:52:17,751 INFO  (main) [RuleBase] ##################### RuleBase start
2016-12-27 16:52:19,431 INFO  (main) [KieRepositoryImpl] KieModule was added: MemoryKieModule[releaseId=org.default:artifact:1.0.0-SNAPSHOT]
2016-12-27 16:52:19,643 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 0 tx/sec
2016-12-27 16:52:20,656 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 99,934 tx/sec
2016-12-27 16:52:21,679 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 308,091 tx/sec
2016-12-27 16:52:22,700 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 331,749 tx/sec
2016-12-27 16:52:23,721 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 351,276 tx/sec
2016-12-27 16:52:24,721 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 351,285 tx/sec
2016-12-27 16:52:25,732 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 349,222 tx/sec
2016-12-27 16:52:26,746 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 339,559 tx/sec
2016-12-27 16:52:27,754 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 328,000 tx/sec
2016-12-27 16:52:28,756 INFO  (pool-1-thread-1) [PerfCounter] ReteOO_Exists : 328,937 tx/sec
2016-12-27 16:52:29,647 INFO  (main) [RuleBase] ##################### disposeAll end
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.056 sec - in org.mk300.brms.perf.ReteOO_Exists
```
