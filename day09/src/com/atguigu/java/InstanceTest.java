package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月15日 下午7:45
 */
/*
一、万事万物皆对象。
>将功能、结构等封装到类中，通过类的实例化，调用具体的功能结构。
>与html、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象

二、内存解析说明
1、引用类型的变量，只可能存储两类值：null或地址值（含变量的类型），如：[I@16b98e56,表示int类型。

三、匿名对象
>匿名对象没有名，直接用new 类名（）定义
>匿名对象只能用一次，因为没有名字，后续无法调用

 */
public class InstanceTest {
    public static void main(String[] args) {
        String [] a = new String[4];
        System.out.println(a);  //打印地址值
        System.out.println(a[1]); //null,String是引用类型，没赋值的时候是null。对象没有new的时候也是null
        int[] b = new int[4];
        b = null;
        System.out.println(b); //null
        String s = new String("kang");  //与对象类似，String类型也是引用类型，也可以用new方法实例化
                                                //不过String类型特殊，可以直接赋值。
        System.out.println(s);
        Phone p = new Phone();
        System.out.println(p); //类型和地址值：com.atguigu.java.Phone@27d6c5e0
        p.sendEmail();

        //匿名对象
        new Phone().price = 2000;
        new Phone().getPrice();  //输出默认值，0.0
    }
}
class Phone{
    double price;
    public void sendEmail(){
        System.out.println("发送邮件");
    }
    public void playGame(){
        System.out.println("玩游戏");
    }
    public void getPrice(){
        System.out.println("手机的价格为："+price);
    }
}
