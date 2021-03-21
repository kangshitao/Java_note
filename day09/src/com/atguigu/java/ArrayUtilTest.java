package com.atguigu.java;

import java.util.Arrays;

/**
 * @author Kangshitao
 * @date 2021年3月15日 下午8:24
 */
public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil arrayutil = new ArrayUtil();
        int[] arr = new int[]{1,2,3,4};
        int max = arrayutil.getMax(arr);
        System.out.println("数组的最大值为："+max);
        arrayutil.arraySort(arr);
    }
}
