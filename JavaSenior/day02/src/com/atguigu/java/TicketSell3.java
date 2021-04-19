package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月30日 上午10:09
 */
/*
使用同步方法解决实现Runnable接口的线程安全问题
 */
public class TicketSell3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        //创建三个线程，即三个窗口
        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() { //同步方法。默认的同步监视器是this
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

