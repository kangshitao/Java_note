package com.atguigu.java.exer;

/**
 * @author Kangshitao
 * @date 2021年3月18日 上午10:36
 */
public class Kids extends ManKind {
    private  int yearsOld;

    public Kids() {
    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println(yearsOld);
    }
}
