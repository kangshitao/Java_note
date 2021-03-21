package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月17日 下午7:45
 */
public class Student extends Person {
    String major;

    public Student() {

    }

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public void study() {
        System.out.println("study");
    }

    public void shoeInfo(){
        System.out.println("name:"+name+"age:"+age);
    }
}
