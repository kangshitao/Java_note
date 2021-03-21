package com.atguigu.java.exer;

/**
 * @author Kangshitao
 * @date 2021年3月18日 上午10:34
 */

/*
继承性练习
 */
public class ManKind {
    private int sex;
    private int salary;

    public ManKind(){}
    public ManKind(int sex, int salary){
        this.sex = sex;
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWoman(){

    }

    public void employeed(){

    }
}
