package com.atguigu.exer;

/**
 * @author Kangshitao
 * @date 2021年3月14日 下午5:05
 */
/*
课时191，练习3
 */
public class Exer3Test {
    public static void main(String[] args) {
        Exer3Test test = new Exer3Test();
        int area = test.method(6, 5);
        System.out.println("面积为:" + area);
    }

    public int method(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        return m * n;
    }
}
