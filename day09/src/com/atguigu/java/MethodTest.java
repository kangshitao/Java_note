package com.atguigu.java;

import java.rmi.StubNotFoundException;

/**
 * @author Kangshitao
 * @date 2021年3月15日 下午9:13
 */

/*
可变个数形参方法。
 */
public class MethodTest {
    public static void main(String[] args) {
        MethodTest m = new MethodTest();
        m.show(1,2);
        m.show(new int[]{1,2,3,4});
        m.show("sss",1,3,4,5); //两种参数方法都可以。
    }
    public void show(int i){
        System.out.println("a");
    }

    public void show(int ... i){  //可变形参，可以接收任意个数的参数。也可以接受数组类型的参数。
        System.out.println("可变形参");
    }
    public void show(int a, int b){
        System.out.println("ab");
    }

    public void show(String s, int ... i){  //可变形参必须放在最后。
        for(int n = 0; n<i.length; n++){ //将i当成数组处理即可。

        }
    }
}