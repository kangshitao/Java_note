package com.atguigu.java.Polymorphism;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午4:47
 */
public class Man extends Person{
    private boolean isSmoking;

    public void earnMoney(){
        System.out.println("Man:earnMoney");
    }
    public void eat(){
        System.out.println("Man:eat");
    }

    public void walk(){
        System.out.println("Man:walk");
    }
}
