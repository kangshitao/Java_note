package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月16日 下午5:04
 */

/*
一、封装性的体现-四种权限：
>使用getXXX和setXXX获取和设置对象的属性，隐藏对象属性，即私有化属性，私有化属性对外不可见。
>不暴露私有的方法
>单例模式（将构造函数私有化）
>如果不希望类在包外被使用，可以将类设置为缺省的。
>>以上四点仅是一部分体现。

二、四种权限修饰符，封装性的体现需要权限修饰符来配合
1.private：类内部 可访问
2.缺省（default）：类内部、同一个包 可访问
3.protected：类内部、同一个包、不同包的子类 可访问
4.public：类内部、同一个包、不同包的子类、同一个工程 可访问
以上四种权限可以用来修饰类、类的内部结构，属性、方法、构造器、内部类，体现了可见性的大小。
***特别的，类只可以用public和缺省。public类可以在任意地方被访问，缺省类只可以在同一个包内部的类访问。


 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.setName("Ani");
        a.setAge(1);
        a.setLegs(4);
        a.show();
        System.out.println(a.getAge());
    }
}

class Animal {
    private String name;
    private int age;
    private int legs;  //类的属性限制为private权限，只能当前类使用。防止别的类修改。

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;  //形参重名的时候，需要用this区分类属性和形参。
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;  //当形参名和类的属性名不一致时，用不用this区分都可以。
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int l) {//使用赋值方法，限制legs的范围，只能是正整数
        if (l >= 0 && l % 2 == 0) {
            legs = l;
        } else {
            legs = 0;
        }
    }

    public void eat() {
    }

    public void show() {
        System.out.println("name=" + name + ",age=" + age + ",legs=" + legs);
    }
}
