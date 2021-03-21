package com.atguigu.java.ObjectClass;

/**
 * @author Kangshitao
 * @date 2021年3月19日 上午9:45
 */
/*
一、==和equals()的区别
1. ==是运算符，可以使用在
    ①可以使用在基本数据类型变量和引用数据类型变量中
    ②如果是基本数据类型变量：比较两个变量保存的数据是否相等（类型不一定要相同）
     如果比较的是引用数据类型的变量：比较两个对象的地址值是否相同。即两个引用是否指向同一个对象实体。
    ③必须保证左右两边变量类型一致，能够相比。比如int和char可以。两个不同类型的对象不可以。
2.equals方法
    ①是一个方法，而非运算符
    ②只能适用于引用数据类型。
    ③Object类中equals()方法和 == 符号作用是相同的，比较的是两个对象的地址值是否相同。
         public boolean equals(Object obj) {
                return (this == obj);
         }
    ④像String、Date、File、包装类等都重写了Object类中的equals()方法。
     重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的“实体内容”是否相同
    ⑤通常，自定义的类如果使用equals()方法，也是比较两个对象的实体内容是否相同。需要对equals()重写，用于比较两个对象的实体内容是否相同

二、

 */
public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j); //true
        System.out.println(i == d); //true

        char c = 10;
        System.out.println(i == c); //true
        EqualsTestClass etc1 = new EqualsTestClass("sss",32);
        EqualsTestClass etc2 = new EqualsTestClass("sss",32);
        System.out.println(etc1.equals(etc2));
    }
}
