package com.atguigu.java.Polymorphism;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午4:50
 */
/*
面向对象特征之三：多态性

1.理解多态性：可以理解为一个事物的多种形态。
2.何为多态性：
    对象的多态性：父类的引用指向子类的对象（或者说子类的对象赋给父类的引用）

3.多态的使用：虚拟方法调用
    有了对象的多态性以后，编译时只能调用父类中声明的方法，但在运行时，实际执行的是子类重写的方法
    总结：编译看左边，运行看右边

4.多态性的使用前提：①类的继承关系 ②方法的重写
5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）
6.多态性是运行时的行为（动态绑定），即只有在运行时才知道具体执行哪个方法。在编译时是看不知道的。
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
        Person p2 = new Man();
        Person p3 = new Woman();
        //多态的引用：当调用子父类同名同参数的方法时，实际执行的是子类重写的父类的方法——虚拟方法调用
        p2.eat();
        p3.walk();
    }
}
