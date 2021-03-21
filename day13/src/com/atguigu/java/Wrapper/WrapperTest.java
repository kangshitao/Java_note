package com.atguigu.java.Wrapper;

/**
 * @author Kangshitao
 * @date 2021年3月19日 下午4:12
 */
/*
1.Java提供了8中基本数据类型的包装类，使得基本数据类型的变量具有类的特征
2.基本数据类型、包装类、String三者之间的转换。
    ①基本数据类型→包装类：调用包装类的构造器
        比如 Integer i = new Integer(12);
    ②包装类→基本数据类型：调用包装类的xxxValue():
        比如：
        Integer i = new Integer(12);
        int a = i.intValue();
    >JDK 5.0及以后，有了自动装箱和自动拆箱特征，包装类和基本数据类型可以直接相互转换。比如Integer i = 12;
    >因此，包装类和基本数据类型可以看成是一个整体
    ③包装类、基本数据类型 → String类型,连接符或者用String.valueOf(Xxx xxx):
        方法1：String s = 1 + "";
        方法2: String s = String.valueOf(12);
    ④String类型 → 基本数据类型、包装类，调用包装类的parseXxx(String s)
    ⑤
    ⑥
 */
public class WrapperTest {
    public static void main(String[] args) {
        Integer i = 2;
        String s = i+"";
        s = String.valueOf(12);
        Integer.parseInt(s);
        System.out.println(s);
        Object o1 = new Integer(1);
        Object o2 = new Integer(1);

        System.out.println(o1 == o2); //false

        //Integer 内部定义了IntegerCache结构，IntegerCache定义了Integer[]，
        //保存了从-128~127范围的整数，如果使用自动装箱，在此范围内可以直接使用数组的元素
        //如果不在此范围内，则会new一个对象
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); //true
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); //false
    }
}
