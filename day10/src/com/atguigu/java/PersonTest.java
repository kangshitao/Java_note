package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月16日 下午7:05
 */
/*
一、构造器(构造函数）的使用。
只要新建对象，一定会使用到构造器。
作用：
1.创建对象。创建对象时，new会调用对应的构造方法
2.创建对象，给对象进行初始化。

说明：
1.如果没有显示定义，系统默认提供空参构造器，默认的构造器权限和类一致。。
2.格式 ：权限修饰符 类名（形参列表）{}
3.同一个类中可以有多个构造器，也可以重载。
4.一旦显式地定义了构造器，系统不再提供默认的空参构造器。
5.一个类中，一定会有至少一个构造器。


二、JavaBean.
JavaBean可以理解成一种规范。
符合如下条件的类：
>类是公共的。
>有一个无参的公共的构造器。
>有属性，且有对应的get、set方法。

三、this关键字的使用。
1.this可以用来修饰：属性、方法、构造器
2.this修饰属性和方法：理解成当前对象或当前正在创建的对象。
在类的方法中，使用"this.属性"或者"this.方法"的方式，调用当前对象属性或方法。
但是，通常选择省略“this.”。特殊情况下，形参和属性同名时，必须使用"this."进行区分属性和形参。
3.this调用构造器。
  ①在类的构造器中，可以用“this（形参列表）”方式，调用本类中其他构造器
  ②构造器不能用“this（形参列表）”方式调用自己。
  ③如果一个类中有n个构造器，则最多有n-1个构造器中使用了“this（形参列表）”方式
  ④规定：“this（形参列表）”必须声明在当前构造器的首行。
  ⑤构造器内部，最多只能有一个“this（形参列表）”的方式。且多个构造器之间调用不能形成环。否则死循环。
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person("kang",20); // new 后面的Person()就是构造器。
    }
}
class Person{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //构造器（构造函数）
    public Person(){
        System.out.println("first constructor");
    }

    public Person(String name){
        this();  //使用this调用第一个构造器
        this.name = name;
        System.out.println("second constructor");
    }
    public Person(int age){
        this.age = age;
        System.out.println("third constructor");
    }

    public Person(String name, int age){
        this(name);  //使用this调用第二个构造器
        //this.name = name;
        this.age = age;
        System.out.println("forth constructor");
    }
    
    public void eat(){
    }
}
