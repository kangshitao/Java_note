package com.atguigu.exer;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午9:12
 */
/*
练习1：模拟一个trim方法，去除字符串两端的空格。
 */
public class Exe_trim {
    public static void main(String[] args) {
        Exe_trim t = new Exe_trim();
        String s = "  ";
        System.out.println(s.trim().equals(t.trim(s)));
    }

    public String trim(String s) {
        int length = s.length();
        if (length == 0) return "";
        int start = 0;
        while (start < length) { //获取左边第一个不是空格的序号
            if (s.charAt(start) != ' ') break;
            start++;
        }
        int end = length - 1;
        while (end >= 0) {//获取右边第一个不是空格的序号
            if (s.charAt(end) != ' ') break;
            end--;
        }
        //如果全是空格，则返回空字符串
        return end>=start ? s.substring(start, end+1): "";
    }
}
