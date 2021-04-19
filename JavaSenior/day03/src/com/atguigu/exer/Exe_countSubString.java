package com.atguigu.exer;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午9:56
 */
/*
练习3：获取一个字符串在另一个字符串中出现的次数。
        比如：获取“ab”在“abkkcadkabkebfkabkskabcccccc”中出现的次数为4
 */
public class Exe_countSubString {
    public static void main(String[] args) {
        String s = "abkkcadkabkebfkabkskab";
        String target = "ab";
        Exe_countSubString e3 = new Exe_countSubString();
        int count = e3.findTargetSubString(s,target);
        System.out.println(count);

    }
    public int findTargetSubString(String s, String target){
        int number = 0;
        int index = 0;
        int step = target.length(); //找到以后向后移的长度
        while(index<s.length()){
            System.out.println(index);
            index = s.indexOf(target,index);
            System.out.println(index);
            if(index == -1) break; //当没有目标子串的时候，就返回
            number ++;
            index += step;
        }
        return number;
    }
}
