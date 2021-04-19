package com.atguigu.exer;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午2:51
 */
/*
练习题
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok"; //传递过来的是地址值，由于String的不可变性，不会影响this.str
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str); //good
        System.out.println(ex.ch); //best
    }
}