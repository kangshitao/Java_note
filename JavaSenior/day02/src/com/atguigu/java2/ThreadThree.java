package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Kangshitao
 * @date 2021年3月30日 下午3:42
 */
/*
JDK 5.0 新增的创建线程的方式三：实现Callable接口

1.步骤：
    a.声明实现Callable接口的实现类
    b.重写call方法
    c.声明实现类对象和FutureTask类对象，例如ft，并且构造器的参数为实现类的对象
    d.新建Thread对象t，将ft作为参数传入构造器
    e.调用t的start方法启动线程
    f.（可选）FutureTask对象也可以调用get方法，获取call函数的返回值
 > Future接口可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等。
 > FutureTask是Future接口唯一的实现类
 > FutrueTask同时实现了Runnable、Future接口，它既可以作为Runnable被线程执行，也可以作为Future得到Callable的返回值

2.实现Runnable和实现Callable接口，后者更强大。
    >call()可以有返回值
    >call()可以抛出异常，被外面的操作捕获，获取异常信息
    >Callable支持泛型

 */
public class ThreadThree {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();  //创建实现类的对象
        FutureTask futureTask = new FutureTask(numThread); //创建FutureTask类对象，将实现类对象作为参数
        new Thread(futureTask).start();  //创建Thread类对象，将FutureTask作为Runnable被线程执行

        try {//get的返回值即numThread重写的call的返回值
            Object num = futureTask.get();  //FutureTask作为Future得到Callable的返回值
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class NumThread implements Callable{ //实现Callable接口，并重写call方法
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i%2==0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}