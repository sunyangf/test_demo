package com.sun.yang.performance;

import org.openjdk.jmh.annotations.*;

/**
 * @ClassName JMHTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/21
 **/
public class JMHTest {

    @Benchmark
    @Warmup(iterations = 1,time = 2)
    @Threads(2)
    @Fork(2)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 2,time = 2)
    public void testForEach() {
        NumsSum.foreach();
    }
}
