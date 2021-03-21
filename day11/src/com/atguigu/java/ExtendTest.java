package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月17日 下午7:46
 */
/*
面向对象的特征之二：继承性
一、继承性的优势：
①减少了代码冗余，提高代码复用性
②便于功能的扩展
③为多态性的使用提供了前提。

二、继承性的格式：class A extends B{}
    A：子类、派生类、subclass
    B：父类、超类、基类、superclass
    2.1 体现：一旦子类A继承了父类B，子类A中获取了父类B中声明的结构、属性、方法。
    ***如果父类中的属性或方法是私有的，子类也能继承到，只是由于封装性的影响，子类无法显式调用。
    2.2 子类继承父类以后，还可以声明自己特有的属性和方法，实现功能的扩展。
    子类和父类的关系，不同于子集和集合的关系。

三、Java中关于继承的规定。
    1.一个类可以被多个子类继承
    2.Java中类的单继承性：一个类只能有一个父类
    3.子父类是一个相对的概念，可以多层继承。A→B→C，其中A是C的间接父类。
    4.子类直接继承的父类称为直接父类，间接继承的父类称为间接父类。
    5.子类继承父类以后，就获取了直接父类以及所有间接父类声明的属性和方法。

四、Object类
    1.如果没有显式地声明父类，则此类继承与java.lang.Object类。
    2.所有的java类(除java.lang.Object类以外），都直接或间接地继承于java.lang.Object类
    3.意味着，所有的java类都有java.lang.Object类声明的功能。
 */
public class ExtendTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 1;
        Student s = new Student();
        s.age = 2;
    }
}
