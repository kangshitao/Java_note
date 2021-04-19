package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月29日 下午4:40
 */
/*
创建三个窗口卖票，总票数为100张。使用实现Runnable接口的方式
三个线程共享一个ticket变量
同样存在线程安全的问题
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w2 = new Window2();

        //创建三个线程，即三个窗口
        Thread t1 = new Thread(w2,"窗口1");
        Thread t2 = new Thread(w2,"窗口2");
        Thread t3 = new Thread(w2,"窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
class Window2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"票号为:"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
