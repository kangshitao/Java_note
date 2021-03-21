package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月15日 下午8:37
 */
/*
方法重载。overload
>同一个类中，功能类似，方法名相同的多个方法。参数列表不同（类型，个数，顺序）。返回值类型可以相同也可以不同，但一般返回值类型是相同的。
>两同一不同：类、方法名相同，参数列表不同。
>跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系。

>重写Override
重写是同一个类中，方法名相同，参数列表、返回值都相同，但是方法体（功能）不同。

重写是运行时的多态性，重载是编译时的多态性。
 */
public class OverLoad {
    public static void main(String[] args) {
        OverLoad test = new OverLoad();
    }
    //以下5个getSum是都是重载方法。
    public void getSum(int a, int b){

    }

    public void getSum(double a, double b){

    }

    public void getSum(String s, int i){

    }

    public void getSum(int i, String s){ //也是重载

    }

    public int getSum(int a, int b, int c){  //也算是重载方法。
        return 0;
    }

//    public int getSum(int a, int b){  //不是重载，参数列表相同
//        return 0;
//    }

}
