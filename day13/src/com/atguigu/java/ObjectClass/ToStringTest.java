package com.atguigu.java.ObjectClass;

/**
 * @author Kangshitao
 * @date 2021年3月19日 上午10:56
 */

/*
Object类中toString()的使用。
1、输出一个对象的引用时，实际上就是调用了对象的toString()
2.Object类中toString()的定义：
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
3.像String、Date、File、包装类等都重写了toString()方法，使得在调用对象的toString()时，返回“实体内容”信息
4.自定义类也可以重写toString()方法，当调用此方法时，返回对象的“实体内容”。
 */
public class ToStringTest {
    public static void main(String[] args) {
        ToStringTest test = new ToStringTest();
        System.out.println(test);
        System.out.println(test.toString());
    }
}
