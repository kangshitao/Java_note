package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月21日 上午11:44
 */
public class valueTransfer {
    public static void main(String args[]) {
        valueTransfer t = new valueTransfer();
        t.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }
}

class Value {
    int i = 15;
}