package atguigu.interfacetest;

import java.awt.geom.FlatteningPathIterator;

/**
 * @author Kangshitao
 * @date 2021年3月23日 上午10:21
 */
/*
接口的使用  interface
1.接口使用interface来定义
2.Java中，接口和类是并列的两个结构
3.定义接口：定义接口中的成员
    3.1 JDK7及以前：只能定义全局常量和抽象方法
        >全局常量：public static final,关键字可以省略不写，但还是全局常量。可以通过"接口名.常量"调用。
        >抽象方法：public abstract，同样，public abstract可以省略
    3.2 JDK8: 除了能够定义全局常量和抽象方法之外，还可以定义静态方法、默认方法

4.接口中不能定义构造器，意味着接口不能实例化。
5.接口通过被类实现(implements)来使用。
    如果实现类实现(类似于重写)了接口的所有抽象方法，则此类可以实例化。
    否则，如果没有实现所有抽象方法，此类仍为抽象类。
6.Java类可以实现多个接口，弥补了Java不能多继承的缺陷。先写继承再写实现
    格式：class A extends B implements C，D{}
7.接口和接口之间可以继承，而且可以多继承.
8.接口的具体使用体现了多态性
9.接口可以看成是一种规范。
10.匿名实现类，声明方法和抽象类的匿名子类相同。

抽象类和接口的异同：



 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);//调用全局常量
        System.out.println(Flyable.MIN_SPEED);
        Plane plane = new Plane();
        plane.fly();
    }
}
interface Attack{
    public abstract void attack();
}
interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;  //可以省略不写关键字

    //抽象方法
    public abstract void fly();
    void stop(); //可以省略public abstract
}

class Plane implements Flyable{
    public void fly(){
        System.out.println("plane fly");
    }
    public void stop(){
        System.out.println("plane stop");
    }
}
class Kite implements Flyable{
    @Override
    public void fly() {
        System.out.println("kite fly");
    }
    @Override
    public void stop() {
        System.out.println("kite stop");
    }
}
class Bullet extends Object implements Flyable,Attack{

    @Override
    public void attack() {
    }
    @Override
    public void fly() {
    }
    @Override
    public void stop() {
    }
}

interface A{void a();}
interface B{void b();}
interface C extends A,B{}
class T implements C{  //实现类需要实现其实现的接口的所有抽象方法。
    public void a(){} //如果AB接口的抽象方法重名，则可认为同时实现了两个
    public void b(){}
}