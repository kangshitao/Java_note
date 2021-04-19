package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月30日 上午9:48
 */

/*
使用同步代码块，解决继承Thread类的方式的线程安全问题
 */
public class TicketSell2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();
        w1.setName("Window 1-");
        w2.setName("Window 2-");
        w3.setName("Window 3-");

        w1.start();
        w2.start();
        w3.start();

    }
}

class Window2 extends Thread{
    private static int  ticket = 100;
    static Object object = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (object) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

