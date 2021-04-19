package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月29日 下午3:55
 */
/*
 创建多线程的方式二：实现Runnable接口
1.创建类，实现Runnable接口
2.重写run方法
3.创建实现类对象，作为参数传入Thread构造器
4.Thread对象调用start方法启动线程

优势：
1.避免了单继承的局限性
2.多个线程共享一个接口实现类的对象，非常适合多个相同线程来处理同一份资源

>开发中优先选择实现接口的方式。
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        Thread t1 = new Thread(mt,"Thread-1");
        Thread t2 = new Thread(mt,"Thread-2");//启动多个线程，只需要新建Thread对象.两个线程共享Runnable实现类对象
        t1.start();
        t2.start();
    }
}
class MyThread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i< 100; i++)
            System.out.println(Thread.currentThread().getName());
    }
}