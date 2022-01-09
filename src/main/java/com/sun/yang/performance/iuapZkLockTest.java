package com.sun.yang.performance;

import com.yonyou.iuap.yms.lock.YmsLock;
import com.yonyou.iuap.yms.lock.impl.YmsRedisLockFactory;
import com.yonyou.iuap.yms.lock.impl.YmsZkLockFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName iuapZkLockTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/1
 **/
//吞吐量、平均执行时间指标的数据
@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
//配置预热参数
@Warmup(iterations = 1, time = 3)
//iterations：测量次数；time与timeUnit：每次测量的持续时间，timeUnit指定时间单位
@Measurement(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
//指定100个线程执行基准测试方法
@Threads(100)
//指定一个基准线程执行同一基准测试方法(开启一个进程)
@Fork(1)
//指定字段的共享域
@State(value = Scope.Benchmark)
//指定方法执行耗时单位
@OutputTimeUnit(TimeUnit.SECONDS)
public class iuapZkLockTest {
    private static YmsZkLockFactory ymsZkLockFactory;
    private static Random random;
    private static AtomicLong longAdder;
    @Setup
    public static void init() {
        random = new Random();
        longAdder = new AtomicLong(0);
        CuratorFramework client =
                CuratorFrameworkFactory
                        .builder()
                        .connectString("172.20.46.82:2181")
                        .retryPolicy(new RetryForever(5000))
                        .build();
        client.start();
        ymsZkLockFactory = new YmsZkLockFactory(client, true);
    }
    @Benchmark
    public static void testLockAndUnlockRandom() {
        YmsLock lock = ymsZkLockFactory.getLock(String.valueOf(random.nextInt(999999999)));
        lock.lock();
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }

    }
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(iuapZkLockTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(2)
//                .output("D:\\test-lock-performance")
                .build();
        new Runner(options).run();
    }
}
