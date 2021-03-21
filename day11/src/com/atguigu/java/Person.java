package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月17日 下午7:43
 */
public class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("eat");
    }

    public void sleep() {
        System.out.println("sleep");
    }
}
