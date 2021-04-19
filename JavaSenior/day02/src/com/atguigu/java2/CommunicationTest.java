package com.atguigu.java2;

/**
 * @author Kangshitao
 * @date 2021年3月30日 下午2:59
 */
/*
线程通信。例子：两个线程交替打印1-100。使用wait和notify方法，实现两个线程交替打印数字
1.wait():使当前线程进入阻塞状态(排队等待同步资源)，并释放同步锁(同步监视器)
2.notify():唤醒排队等待同步资源的一个进程，如果有多个线程排队等待同步资源，唤醒优先级高的线程
3.notifyAll():唤醒所有排队等待同步资源的线程

说明：
1.调用wait()、notify()、notifyAll()三个方法的必要条件是当前线程具有对当前对象的监控权，
    也就是说必须在线程持有同步锁的情况下才能调用这三个方法。
    所以，这三个方法必须声明在同步代码块或同步方法中(synchronized)，
    而且必须由锁对象调用。否则出现IllegalMonitorStateException异常。
2.任意对象都能作为同步锁，因此这三个方法在Object类中声明
面试题：
sleep和wait方法的异同：
1.相同点：都可以使当前线程进入阻塞状态
2.不同点：>声明位置不同，sleep声明在Thread类中，wait方法声明在Object类中
         >调用的要求不同。sleep可以在任何需要的场景下使用。wait只能在同步代码块/同步方法中
         >是否释放同步锁：当两个方法都使用在同步代码块/同步方法中时，sleep不会释放同步锁，wait会释放同步锁

总结：
    1.释放锁的操作：同步方法、同步代码块执行结束；
                  遇到break、return终止了代码块、方法的继续执行；
                  出现了未处理的error或Exception，导致异常结束；
                  执行wait()方法
    2.不会释放锁的操作：
                sleep、yield方法；
                执行同步代码时，其他线程调用了该线程的suspend方法将该线程挂起。不会释放同步锁。
                    > 尽量避免使用suspend和resume方法控制线程


 */
public class CommunicationTest {
    public static void main(String[] args) {
        CommunicationThread ct = new CommunicationThread();
        Thread t1 = new Thread(ct, "Thread-1");
        Thread t2 = new Thread(ct, "Thread-2");
        t1.start();
        t2.start();
    }
}

class CommunicationThread implements Runnable {
    private int number = 0;
    public void run() {
        while (true) {
            synchronized (this) {
                notify(); //唤醒另一个线程，只有两个线程，也可以使用notifyAll
                if (number < 100) {
                    number++;
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    try {
                        wait(); //当前线程进入阻塞状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;

            }
        }
    }
}
