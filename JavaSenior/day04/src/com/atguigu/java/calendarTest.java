package com.atguigu.java;

import org.junit.Test;
import java.util.*;

/**
 * @author Kangshitao
 * @date 2021年4月1日 下午4:29
 */
/*
Calendar类(抽象类)的使用
 */
public class calendarTest {
    @Test
    public void testCalendar(){
        System.out.println(new Date()); //当前时间：Sun Apr 04 21:40:07 CST 2021
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); //class java.util.GregorianCalendar

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天是本月的第"+days+"天"); // 今天是本月的第4天

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22); //设置calendar为本月的第22天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);  // 22，此时的calendar是本月的第22天，即4月22日

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3); //calendar减去3天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 19，此时的calendar是本月的第19天，即4月19日

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date); // Mon Apr 19 21:40:07 CST 2021

        //setTime():Date ---> 日历类
        Date date1 = new Date();  //当前日期
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);  //4,今天是本月的第4天

    }
}
