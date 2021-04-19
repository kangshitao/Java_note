package com.atguigu.exer;

import java.util.Arrays;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午9:36
 */
/*
2.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 */
public class Exe_reverse_part {
    public static void main(String[] args) {
        String s = "abcdefg";
        Exe_reverse_part e2 = new Exe_reverse_part();
        System.out.println(e2.reverse(s,1,1));
    }
    public String reverse(String s, int start, int end){
        //思路：如果end和start的值非法，直接返回s。
        // 将要反转的子串取出来放到数组，将数组元素反转，然后再转为字符串，和其余的子串拼接
        if(start <0 || end> s.length() ||start>=end) return s;
        String rev_s = s.substring(start,end);
        char[] res = rev_s.toCharArray();
        for(int i = 0; i<(res.length/2);i++){ //反转数组的元素
            char temp = res[i];
            res[i] = res[res.length-i-1];
            res[res.length-i-1] = temp;
        }
        return s.substring(0,start)+new String(res)+s.substring(end);
    }
}
