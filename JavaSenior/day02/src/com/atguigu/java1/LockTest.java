package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kangshitao
 * @date 2021年3月30日 上午11:51
 */
/*
解决线程安全的方式三：Lock锁，JDK5.0新增
Lock是一个接口，ReentrantLock实现了Lock接口
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w, "window 1");
        Thread t2 = new Thread(w, "window 2");
        Thread t3 = new Thread(w, "window 3");//三个线程公用一个Window对象，同一个锁

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock(); //加锁
            try {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else break;
            } finally {
                lock.unlock(); //解锁
            }
        }
    }
}