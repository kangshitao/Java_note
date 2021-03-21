package com.atguigu.java.ObjectClass;

import java.util.Objects;

/**
 * @author Kangshitao
 * @date 2021年3月19日 上午10:06
 */
public class EqualsTestClass {
    private String name;
    private int age;

    public EqualsTestClass(){}
    public EqualsTestClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsTestClass that = (EqualsTestClass) o;
        return age == that.age && Objects.equals(name, that.name);
    }


    //    public boolean equals(Object obj){
//        if(this == obj){
//            return true;
//        }
//        if(obj instanceof EqualsTestClass){
//            EqualsTestClass etc = (EqualsTestClass) obj;
//            //比较两个对象的属性是否相等
//            return this.age == etc.age && this.name.equals(etc.name);
//        }
//        return false;
//    }

}
