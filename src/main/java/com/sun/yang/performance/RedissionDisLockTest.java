package com.sun.yang.performance;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName DisKockTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/9/28
 **/
//吞吐量、平均执行时间指标的数据
@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
//配置预热参数
@Warmup(iterations = 1, time = 3)
//iterations：测量次数；time与timeUnit：每次测量的持续时间，timeUnit指定时间单位
@Measurement(iterations = 1, time = 10, timeUnit = TimeUnit.SECONDS)
//指定100个线程执行基准测试方法
@Threads(100)
//指定一个基准线程执行同一基准测试方法
@Fork(1)
//指定字段的共享域
@State(value = Scope.Benchmark)
//指定方法执行耗时单位
@OutputTimeUnit(TimeUnit.SECONDS)
public class RedissionDisLockTest {

    private static RedissonClient redissonClient;
    private static AtomicLong longAdder;
    private static Random random;
    @Setup
    public static void init() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://172.20.46.82:7300")
                .setPassword("YLDR8GRNRUopFT4N")
                .setDatabase(0)
                .setKeepAlive(true)
                .setConnectTimeout(10000)
                .setIdleConnectionTimeout(10000)
                .setConnectionPoolSize(100)
                .setTcpNoDelay(true);

        redissonClient = Redisson.create(config);

        longAdder = new AtomicLong(0);
        random = new Random();
    }

    @TearDown
    public static void destroy() {
        if (redissonClient != null) {
//            redissonClient.de
        }
    }
    @Benchmark
    public static void testLockAndUnlockIncrement() {
        RLock disLock = redissonClient.getLock(String.valueOf(longAdder.getAndIncrement()));
        boolean isLock;
        try {
            //尝试获取分布式锁
            disLock.lock();
        } catch (Exception e) {
        } finally {
            // 无论如何, 最后都要解锁
            disLock.unlock();
        }
    }


    public static void main(String[] args) throws  RunnerException {
        Options opt = new OptionsBuilder()
                .include(NumsSum.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(opt).run();
    }
}
