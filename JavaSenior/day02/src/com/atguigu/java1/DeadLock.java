package com.atguigu.java1;

/**
 * @author Kangshitao
 * @date 2021年3月30日 上午11:47
 */
/*
死锁：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
>这里的同步资源指的就是锁。A线程持有锁a，等待操作b，而B线程持有锁b，等待操作a（此时a被A当作锁持有，没有释放），这就形成了死锁。

解决方法：
1.专门的算法、原则
2.尽量减少同步资源的定义
3.尽量避免嵌套同步

说明：
1.出现死锁以后没有异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
2.使用同步时要避免出现死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread() {//Thread的匿名实现类
            @Override
            public void run() {
                synchronized (s1) {
                    s2.append("a"); //持有同步锁 s1，等待s2被释放
                    System.out.println(getName() + ":" + s1);
                    System.out.println(getName() + ":" + s2);
                }
            }
        }.start();
        new Thread() { //Thread的匿名实现类
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("b");//持有同步锁 s2，等待s1被释放，造成死锁
                    System.out.println(getName() + ":" + s1);
                    System.out.println(getName() + ":" + s2);
                }
            }
        }.start();
    }
}