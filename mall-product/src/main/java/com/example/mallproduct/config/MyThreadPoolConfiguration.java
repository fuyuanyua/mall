package com.example.mallproduct.config;

import com.example.mallproduct.config.properties.ThreadPoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Description: MyThreadPoolConfiguration
 * @Author: lhb
 * @Date: 2021/5/10 20:50
 */

@Configuration
public class MyThreadPoolConfiguration {

    /**
     * 线程池：
     *      1。工作流程：
     *          1。）线程池创建，准备好corePoolSize的核心线程，准备接受任务
     *          2。）核心线程满了，再放进来的任务就进入阻塞队列
     *          3。）阻塞队列也满了，就开启新的线程直到线程总数达到maximumPoolSize
     *          4。）
     *              4。1）如果任务都执行好了，那么除了核心线程外的其他线程都会在keepAliveTime个时间单位后自动销毁
     *              4。2）如果线程总数到达maximumPoolSize后还不断有任务进来，那么就会使用指定的拒绝策略来拒绝这些任务
     * @param properties
     * @return
     */
    @Bean
    public ThreadPoolExecutor threadPoolExecutor(ThreadPoolProperties properties) {
        return new ThreadPoolExecutor(
                // 核心线程数
                properties.getCorePoolSize(),
                // 最大线程数
                properties.getMaximumPoolSize(),
                // 除核心线程外其他线程的最大存活时间
                properties.getKeepAliveTime(),
                // 存活时间单位
                TimeUnit.SECONDS,
                // 阻塞队列
                new LinkedBlockingDeque<>(100000),
                // 创建线程的工厂
                Executors.defaultThreadFactory(),
                // 拒绝策略
                new ThreadPoolExecutor.AbortPolicy());
    }
}
