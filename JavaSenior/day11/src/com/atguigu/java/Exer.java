package com.atguigu.java;

import java.lang.reflect.Field;

/**
 * @author Kangshitao
 * @date 2021年4月15日 下午3:23
 */
public class Exer {
    public static void main(String[] args) throws NoSuchFieldException {
        test t = new test();
        Class cla = t.getClass();
        Field f1 = cla.getDeclaredField("id");
        f1.setAccessible(true);
        System.out.println(f1.getType());
        Field name = test.class.getDeclaredField("name");
        //name.setAccessible(true);
        System.out.println(name.getType());
    }
}
class test{
    private int id = 1001;
    private String name = "Tom";
}