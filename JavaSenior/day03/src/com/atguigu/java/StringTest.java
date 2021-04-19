package com.atguigu.java;

import org.junit.Test;

/**
 * @author Kangshitao
 * @date 2021年3月31日 上午11:01
 */
/*
String的使用
1.String声明为final的，不可被继承
2.String实现了Serializable接口，表示字符串是支持序列化的。
        实现了Comparable接口，表示字符串可以比较大小
3.String内部定义了final char[] value，用于存储字符串数据。数组不能被重新赋值，数组元素不能被修改
4.String代表不可变的字符序列，不可变性
    >当对字符串重新赋值时，需要重写指定内存区域进行赋值，不能使用原有的value进行赋值
    >当对现有的字符串进行连接操作时，也需要重写指定内存区域进行赋值，不能使用原有的value进行赋值
    >当调用String的replace方法修改指定的字符/字符串时，也需要重写指定内存区域进行赋值，不能使用原有的value进行赋值
5.通过字面量的方式(区别于new的方式)给字符串赋值，字符串的值声明在字符串常量池中
6.字符串常量池中不会保存相同内容的字符串。

String的实例化方式：
方式一：通过字面量定义.存储在方法区的字符串常量池中
方式二：new + 构造器，新建String类型对象的方式。存储在堆中

*** String s = new String("abc");的方式创建字符串，内存中一共创建了两个对象。
    一个是堆中new的结构，另一个是char[]对应的常量池中的"abc"

7.字符串的特性：
    >常量与常量的拼接结果在常量池（final修饰的也是常量）。且常量池中不会存在相同内容的常量。
    >只要其中有一个是变量，结果就在堆中。比如s1 + s2、s1+"abc"、s1+="abc"等，用==比较是false，比如s1+"abc" == s1+"abc"为false
    >如果拼接的结果调用intern()方法，返回值就在常量池中

 */
public class StringTest {
    @Test
    public void test1(){
        String s1 = "abc";  //字面量的定义方式
        String s2 = "abc"; //s1和s2指向同一个地址
        System.out.println(s1 == s2);
        s1 = "hello"; //此时s1指向了新的地址值
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "abc";
        s3 += "def";
        System.out.println(s2);

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);
    }

    @Test
    public void test2(){
        //s1\s2的数据保存在方法区中的字符串常量池
        String s1 = "java";
        String s2 = "java";
        //s3和s4保存的是地址值，指向堆中的value,此时的value是数组，也是地址值，value指向常量池中的“java"
        String s3 = new String("java");
        String s4 = new String("java");
        System.out.println(s1 == s2); //true
        System.out.println(s3 == s4); //false
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println((s1+"java" )== (s1+"java")); //false

    }
}
