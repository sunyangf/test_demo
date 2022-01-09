package com.sun.yang.performance;

import com.yonyou.iuap.yms.lock.YmsLock;
import com.yonyou.iuap.yms.lock.impl.YmsRedisLockFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName iuapDisLockTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/9/28
 **/
//吞吐量、平均执行时间指标的数据
@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
//配置预热参数
@Warmup(iterations = 1, time = 3)
//iterations：测量次数；time与timeUnit：每次测量的持续时间，timeUnit指定时间单位
@Measurement(iterations = 1, time = 2, timeUnit = TimeUnit.SECONDS)
//指定100个线程执行基准测试方法
@Threads(10)
//指定一个基准线程执行同一基准测试方法(开启一个进程)
@Fork(1)
//指定字段的共享域
@State(value = Scope.Benchmark)
//指定方法执行耗时单位
@OutputTimeUnit(TimeUnit.SECONDS)
public class iuapDisLockTest {
    private static YmsRedisLockFactory ymsRedisLockFactory;
    private static Random random;
    private static AtomicLong longAdder;
    private static StringRedisTemplate stringRedisTemplate;
    private static RedisConnectionFactory redisConnectionFactory;

//    @Param({"10000", "100000", "1000000", "10000000"})
//    public int size;

    @Setup
    public static void init() {
        random = new Random();
        longAdder = new AtomicLong(0);
        redisConnectionFactory = createRedisConnectionFactory(createGenericObjectPoolConfig());
        stringRedisTemplate = build(redisConnectionFactory);
        ymsRedisLockFactory = new YmsRedisLockFactory(stringRedisTemplate, true);
    }
    @TearDown
    public static void close() {
        if (redisConnectionFactory != null && redisConnectionFactory instanceof LettuceConnectionFactory) {
            LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) redisConnectionFactory;
            jedisConnectionFactory.destroy();
        }
    }

    public static StringRedisTemplate build(RedisConnectionFactory redisConnectionFactory) {

        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        //2.设置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //3.设置redis生成的key的序列化器，对key编码进行处理

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    public static GenericObjectPoolConfig createGenericObjectPoolConfig() {
        //1.创建Jedis连接池的配置对象
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        //2.设置连接池信息
        genericObjectPoolConfig.setMaxTotal(1000);
        genericObjectPoolConfig.setMinIdle(10);
        genericObjectPoolConfig.setMaxIdle(50);
        genericObjectPoolConfig.setMaxWaitMillis(1000000);
        //3.返回
        return genericObjectPoolConfig;
    }

    //配置Redis连接工厂
    public static RedisConnectionFactory createRedisConnectionFactory(GenericObjectPoolConfig genericObjectPoolConfig) {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("172.20.46.82", 7300);
        redisStandaloneConfiguration.setPassword("YLDR8GRNRUopFT4N");
        //YLDR8GRNRUopFT4N
        //1.创建配置构建器，它是基于池的思想管理Jedis连接的
//        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
//        //2.设置池的配置信息对象
//        builder.poolConfig(genericObjectPoolConfig);


        //3.创建Jedis连接工厂
        LettuceConnectionFactory jedisConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        //4.返回
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    @Benchmark
    public static void testLockAndUnlockRandom() {
        YmsLock ymsLock = ymsRedisLockFactory.getLock(String.valueOf(random.nextInt(999999999)));
        try {
            ymsLock.lock();
        } finally {
            try {
                ymsLock.unLock();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

    }


    @Benchmark
    public static void testLockAndUnlockIncrement() {
        YmsLock ymsLock = ymsRedisLockFactory.getLock(String.valueOf(longAdder.getAndIncrement()));
        try {
            ymsLock.lock();
        } finally {
            try {
                ymsLock.unLock();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(iuapDisLockTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(2)
//                .output("D:\\test-lock-performance")
                .build();
        new Runner(options).run();
    }
}
