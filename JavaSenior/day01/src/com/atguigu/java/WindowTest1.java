package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月29日 下午4:10
 */

/*
创建三个窗口卖票，总票数为100张。使用继承Thread类的方式
        > 为了保证三个窗口共享100张票，一种方式是将ticket设置为static。
            这种方式有线程安全的问题。
        > 如果不使用static，可以使用第二种创建线程的方法。

        创建多线程的方式二：实现Runnable接口
*/

class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(getName()+"票号为:"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

