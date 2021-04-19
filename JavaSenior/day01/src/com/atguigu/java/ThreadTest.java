package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月29日 上午11:00
 */
/*
一、程序、进程和线程

1.程序(program)是为完成特定任务、用某种语言编写的一组指令的集合，即指一段静态的代码，静态对象。
2.进程(process)是是程序的一次执行过程，是正在运行的一个程序。是一个动态的过程：有自身的产生、存在和消亡的过程——生命周期
    程序是静态的，进程是动态的。进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域
3.线程(thread)。进程可进一步细化为线程，是一个程序内部的一条执行路径。
    若一个进程同一时间并行执行多个线程，就是支持多线程的
    线程是调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(pc)，线程切换开销小
    一个进程中的多个线程共享相同的内存单元/内存地址空间→它们从同一堆中分配对象，可以访问相同的变量和对象。使得多个线程间通信简便、高效。
    但多个线程操作共享的系统资源可能会带来安全的隐患。
> 一个进程的多个线程共享进程的堆和方法区。每个线程有自己的程序计数器、虚拟机栈和本地方法栈。
> 一个Java应用程序java.exe，至少有三个线程：main()主线程、gc()垃圾回收线程、异常处理线程
> 并行：多个CPU同时执行多个任务。比如多个人同时做不同的事情
> 并发：一个CPU(采用时间片)"同时"执行多个任务。
可以参考：https://www.zhihu.com/question/264627396
二、多线程
优势：
    1.提高应用程序的相应
    2.提高CPU利用率
    3.改善程序结构，将进程分为多个线程，独立运行，便于理解和修改
应用场景：
    1.需要同时两个及以上任务
    2.程序需要实现一些需要等待的任务，如用户输入、文件读写等
    3.需要一些后台运行的程序时。

三、多线程的创建：
Java中每个线程都是通过Thread类对象的run方法完成操作的，调用其start方法启动线程。JDK 5.0之前有两种方法创建线程.
方式一：继承于Thread类
    1：创建一个继承于Thread类的子类
    2：重写run()方法，将此线程执行的操作声明到此方法中
    3：创建Thread类的子类的对象
    4：通过此对象调用start()方法。
        start方法作用：启动当前线程；调用当前线程的run()
    例子：遍历100以内所有的偶数.

注意：1.启动多线程，必须调用start方法。不能通过直接调用run()的方式启动线程。
     2.不能让已经start()的线程再start()，即一个线程不能启动多次。IllegalThreadStateException异常。
        如果想创建多个线程，需要创建多个Thread对象
 */

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread1 mt = new MyThread1();
        //4.通过此对象调用start()方法
        mt.start(); //主线程使用mt对象调用了start方法，启动新线程。
        // start方法能够使线程执行，JVM调用这个线程的run方法

        //这里是主线程运行
        //同时运行两个线程，输出顺序就不确定，每个线程的输出也可能交叉
        for( int i = 0; i<100;i++){
            if(i % 2 != 0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
// 1.创建一个继承于Thread类的子类
class MyThread1 extends Thread{
    //2.重写Thread的run()
    @Override
    public void run() {
        for(int i = 0; i<100;i++){
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}