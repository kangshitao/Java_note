package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月29日 下午4:40
 */
/*
创建三个窗口卖票，总票数为100张。使用实现Runnable接口的方式
三个线程共享一个ticket变量
同样存在线程安全的问题。
1.问题：出现重票、错票现象，即出现了线程的安全问题
2.原因：某个线程操作过程中，操作尚未完成时，其他线程参与进来
3.如何解决：一个线程在操作时，其他线程不能参与进来，直到当前线程操作完，其他线程才可以操作。
            即使当前线程出现了阻塞，也不能被改变。
4.Java中使用同步机制，解决线程安全问题
    方式一：同步代码块
    synchronized(同步监视器)｛
        //需要被同步的代码
    ｝
    >1.操作共享数据的代码，即为需要被同步的代码。（不能多也不能少）
    >2.共享数据：多个线程共同操作的数据，比如本例的ticket
    >3.同步监视器，即“锁、同步锁”：任何一个类的对象都可以充当锁
        要求多个线程必须共用同一把锁，即多个线程的锁必须是同一个对象
        >实现Runnable接口创建多线程的方式中，可以考虑使用this充当锁
        >而在继承Thread类创建多线程的方式中，要慎用this作为锁。也可以考虑当前类作为同步锁(类也是对象，即Window.class)

    方式二：同步方法。如果操作共享数据的代码完整的声明在一个方法中，可以将此方法声明为同步的
            可以将多个方法都使用synchronized监视起来，解决这几个方法的线程安全问题
    同步方法总结：
    >同步方法仍然涉及到同步监视器，只是不需要我们显式声明
    >非静态的同步方法，同步监视器是this
     静态的同步方法，同步监视器是：当前类本身(类也是对象,即"类名.class")

    方式三：Lock锁(和同步锁的概念不同，注意区分)，JDK5.0新增
         >使用Lock时，同样需要保证多个线程使用同一个ReentrantLock对象
5.同步的利弊：
    a.解决了进程的安全问题。
    b.操作同步代码时，只能一个线程参与，其他线程等待，相当于是一个单线程的过程，效率变低

面试题：synchronized和Lock的异同：
    1.相同点：二者都可以解决线程安全问题
    2.不同：synchronized是隐式锁，在执行完相应的同步代码后，自动释放同步锁(同步监视器)
           Lock是显式锁，需要手动启动同步(Lock()),结束时也需要手动关闭(unLock())
           Lock只有代码块锁，synchronized有代码块锁和方法锁
    使用的优先顺序：Lock→同步代码块（已经进入了方法体，分配了相应资源） → 同步方法（在方法体之外）
 */
public class TicketSell {
    public static void main(String[] args) {
        Window w = new Window();
        //创建三个线程，即三个窗口
        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Window implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //synchronized (this){
            //synchronized (Window.class){
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "票号为:" + ticket);
                    ticket--;
                } else break;
            }
        }
    }
}
