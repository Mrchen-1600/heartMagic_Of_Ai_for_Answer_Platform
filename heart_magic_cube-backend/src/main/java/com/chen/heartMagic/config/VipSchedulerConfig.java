package com.chen.heartMagic.config;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * VIP用户单独一个线程池
 */
@Configuration
@Data
public class VipSchedulerConfig {

    /**
     * 创建了一个自定义的线程工厂，并使用它来创建一个调度执行器服务（ScheduledExecutorService）。
     * 然后，它将这个调度执行器服务转换为一个RxJava的调度器（Scheduler）。
     * @return
     */
    @Bean
    public Scheduler vipScheduler() {
        //ThreadFactory是一个接口，用于创建新线程。通过实现这个接口，可以自定义线程的创建过程。
        ThreadFactory threadFactory = new ThreadFactory() {
            //自定义的线程工厂包含一个AtomicInteger类型的threadNumber变量，用于生成线程的名称。
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(@NotNull Runnable r) {
                // 每次创建新线程时，线程名称会加上一个递增的数字，以区分不同的线程。
                Thread thread = new Thread(r, "VIPThreadPool-" + threadNumber.getAndIncrement());
                // 设置为非守护线程。守护线程在应用程序结束时会被自动终止，这可能会导致任务无法正常完成。因此，通常将线程设置为非守护线程。
                thread.setDaemon(false);
                return thread;
            }
        };
        //创建了一个具有10个线程的调度执行器服务，并使用自定义的线程工厂来创建这些线程
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10, threadFactory);
        //将ScheduledExecutorService转换为一个RxJava的调度器（Scheduler）
        return Schedulers.from(scheduledExecutorService);
    }
}
