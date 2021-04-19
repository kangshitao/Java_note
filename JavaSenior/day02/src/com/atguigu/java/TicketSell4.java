package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月30日 上午10:16
 */
/*
使用同步方法，解决继承Thread类的方式的线程安全问题。

 */
public class TicketSell4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("Window 1-");
        w2.setName("Window 2-");
        w3.setName("Window 3-");

        w1.start();
        w2.start();
        w3.start();

    }
}

class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show(){ //同步监视器当前类。
    //private synchronized void show(){ //同步监视器是this，即w1,w2,w3，是错的。解决方法，将方法改为static的
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "票号为:" + ticket);
            ticket--;
        }
    }
}


