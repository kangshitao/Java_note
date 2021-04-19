package com.atguigu.exer;

/**
 * @author Kangshitao
 * @date 2021年3月29日 下午9:26
 */

/*
练习：创建两个分线程，让其中一个线程输出1-100之间的偶数，另一个线程输出1-100之间的奇数。
 */
public class exe1 {
    public static void main(String[] args){
        ExeThreadEven e1 = new ExeThreadEven();
        ExeThreadOdd e2 = new ExeThreadOdd();
        e1.setName("Even");
        e1.start();
        new Thread(e2,"Odd").start();
    }
}
class ExeThreadEven extends Thread{
    public void run(){
        for(int i = 0;i<100;i++){
            if(i%2==0)
                System.out.println(getName()+":"+i);
        }
    }
}
class ExeThreadOdd implements Runnable{
    public void run(){
        for(int i = 0;i<100;i++){
            if(i%2 != 0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}