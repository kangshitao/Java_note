package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午4:50
 */
/*
一、向下转型

二、instanceof关键字的使用
    1.使用方法：  a instanceof A：判断对象a是否是类A的实例，如果是，返回true，否则返回false.
    2.使用情景：为了避免向下转型时出现ClassCashException的异常，在向下转型之前，先进行instanceof判断。返回true则进行向下转型。
             返回false则不进行向下转型。
    3.假设类B是类A的父类，即A extends B，如果a instanceof A返回true，则a instanceof B也返回true
    4.向下转型常见的几个问题：
        ①编译通过，运行不过，例如。
            Person p =  new Woman();
            Man m = (Man) p;
            或
            Person p = new Person();
            Man m = (Man) p;
            这两种都是不可以的。
        ②编译通过，运行也通过，例如：
            Object obj = new Woman();
            Person p = (Person) p;  这种情况是可以的，正确。
        ③编译不通过：
            Man m = new Woman();  不可以

 */
public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.eat();

        Man m1 = new Man();
        m1.eat();

        Woman w1 = new Woman();
        w1.eat();

        //对象的多态性：父类的引用指向子类的对象。
        System.out.println("-----------多态性-----------");
        Person p2 = new Man(true);
        Person p3 = new Woman();
        //多态的引用：当调用子父类同名同参数的方法时，实际执行的是子类重写的父类的方法——虚拟方法调用
        p2.eat();
        p3.walk();
        //不能调用子类特有的方法和属性，因为编译时，p2是Person类型，Person类没有earnMoney()方法
        //p2.earnMoney();
        //有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明时为父类类型，
        //导致编译时，只能调用父类中声明的属性和方法，子类特有的属性和方法不能调用。

        //如何才能调用子类特有的属性和方法？
        //使用强制类型转换，称为向下转型。类似于较高级基本数据类型强制转换为较低级的基本数据类型，比如double强制转换为int
//        Man m2 = (Man)p2;
//        m2.earnMoney();

        //使用强转时，可能出现ClassCaseException的异常。
        //为了避免出现这种异常，在转换时使用instanceof关键字进行判断。
        if(p2 instanceof Woman){
            Woman w2 = (Woman) p2;
            w2.goShopping();
            System.out.println("*******Woman*******");
        }

        if(p2 instanceof Man){
            Man m2 = (Man) p2;
            m2.earnMoney();
            System.out.println("*******Man*******");
        }
    }
}
