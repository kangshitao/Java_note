package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月29日 下午12:02
 */
/*
Thread中常用的方法。
1.start():启动线程，并执行对象的run方法
2.run():线程被调度时执行的操作
3.currentThread():返回当前线程
4.getName():
5.setName():
6.yield():释放当前cpu的执行权
7.join()：在线程A中调用线程B的join方法，此时A进入阻塞状态，直到线程b完全执行完以后，线程A才结束阻塞状态
8.stop():已过时。强制结束当前线程
9.sleep(long millitime)：让当前线程睡眠指定的毫秒。指定的毫秒时间内，当前线程是阻塞状态。
10.isAlive()：
线程的优先级：
1.10,1,5
2.设置优先级：
getPriority
setPriority

> 高优先级线程抢占低优先级线程cpu的执行权。只是从概率上讲，不意味着高优先级一定会先于低优先级

守护线程和用户线程
守护线程比如Java垃圾回收。当JVM中都是守护线程时，当前JVM将退出
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadMethod tt = new ThreadMethod("Thread:1");
        tt.start();
        for(int i = 0;i<100;i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName()+":"+i);
            if(i == 20){
                try{
                    tt.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class ThreadMethod extends Thread{
    public ThreadMethod(String name){
        super(name);
    }
    public void run(){
        for(int i = 0;i<100;i++){
            if(i%2==0)
                System.out.println(getName()+":"+i);
        }
    }
}
