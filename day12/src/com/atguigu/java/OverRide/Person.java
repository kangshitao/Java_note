package com.atguigu.java.OverRide;

/**
 * @author Kangshitao
 * @date 2021年3月18日 上午11:04
 */
public class Person {
    private String name = "defalut name";
    private int age = 1;
    public int id = 371522;
    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("person eat");
    }

    public void walk(int distance){
        System.out.println("walk distance is:"+distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
