package com.atguigu.java.ObjectClass;

/**
 * @author Kangshitao
 * @date 2021年3月19日 上午9:11
 */

/*
Java.lang.Object类
1.Object类是所有Java类的根父类
2.如果类的声明中没有使用extends关键字指明父类，则默认父类为java.lang.Object
3.Object类中的功能(属性、方法)具有通用性
    属性：无
    方法：equals()/toString()/getClass()/hashCode()/clone()/finalize()/wait()/notify()/notifyAll()

4.Object类只声明了一个空参的构造器
 */
public class ObjectTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getClass().getSuperclass());
        System.out.println(order.toString());
    }
}

class Order{}
