package com.atguigu.java2;

import java.util.concurrent.*;

/**
 * @author Kangshitao
 * @date 2021年3月30日 下午4:04
 */
/*
创建线程的方式之四：使用线程池
优势：
    1.提高响应速度
    2.降低资源消耗
    3.便于线程管理

JDK 5.0 提供了线程池相关的API：ExecutorService和Executors
>>>ExecutorService：真正的线程池接口，常见的实现类为ThreadPoolExecutor
    >void execute(Runnable command):执行任务/命令，一般用来执行Runnable
    ><T>Future<T> submit(Callable<T> task):执行任务，有返回值，一般用来执行Callable
    >void shutdown()：关闭连接池
实现类ThreadPoolExecutor中常用方法：
    >corePoolSize：核心池大小
    >maximumPoolSize：最大线程数
    >keepAliveTime：线程没有任务时，最多保持多长时间后会终止

>>>Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池。
    >Executors.newCachedThreadPool():创建一个可根据需要创建新线程的线程池
    >Executors.newFixedThreadPool(n)：创建一个可重用的固定线程数的线程池
    >Executors.newSingleThreadExecutor()：创建一个只有一个线程的线程池
    >Executors.newScheduledThreadPool(n)：创建一个线程池，可安排在给定延迟后运行命令或者定期地执行

使用步骤：
    1.提供指定线程数量的线程池
    2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
    3.关闭线程池

*/
public class ThreadFour {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //ThreadPoolExecutor类实现了ExecutorService接口
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //通过service1，可以设置线程池的属性...
        service1.setMaximumPoolSize(15);

        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumThreadFour()); //适合于Runnable,分配线程1
        service.execute(new NumThreadFour2()); //适合于Runnable，分配线程2
        service.submit(new FutureTask(new NumThreadFour3())); //适合于Callable，分配线程3
        //3.关闭线程池
        service.shutdown();
    }
}

class NumThreadFour implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class NumThreadFour2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class NumThreadFour3 implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return null;
    }
}