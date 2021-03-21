package com.atguigu.java.Polymorphism;

import java.sql.Connection;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午5:12
 */

//多态性的使用，举例一
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());
        test.func(new Cat());
    }

    //参数是Animal类，可以同时接受Dog和Cat两种类的对象。
    public void func(Animal animal){  //Animal animal = new Dog();
        animal.eat();
        animal.shout();
    }
}

class Animal{
    public void eat(){
        System.out.println("animal:eat");
    }

    public void shout(){
        System.out.println("animal:shout");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("dog:eat");
    }

    public void shout(){
        System.out.println("dog:shout");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("cat:eat");
    }

    public void shout(){
        System.out.println("cat:shout");
    }
}


//举例二
class Order{
    public void method(Object obj){
        //这里参数是Object类型，可以接受任意对象。否则需要写很多重载方法
    }
}

//举例三
class Driver{
    //数据库连接
    //这里的参数使用父类Connection，具体执行的时候需要看new的对象
    public void processData(Connection conn){
        // conn = new MySQLConnection();
        // conn = new OracleConnection....
    }
}