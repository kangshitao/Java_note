package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kangshitao
 * @date 2021年4月1日 下午3:57
 */
/*
java.text.SimpleDateFormat类，对日期Date类的格式化和解析
1.两个操作：
    1.1 格式化：日期-->字符串
    1.2 解析：字符串-->日期
    >要求解析的字符串符合识别的格式（即构造器参数体现的格式）
2.SimpleDateFormat的实例化
 */

public class DateFormatTest {
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //SimpleDateFormat的实例化，默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        //格式化日期
        String format = sdf.format(date);
        System.out.println(format);
        //解析：字符串-->日期
        String str = "4/4/21 下午9:00";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //指定的格式进行格式化和解析
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf2.format(date));
        System.out.println(sdf2.parse(sdf2.format(date)));
    }
    @Test
    public void exe1() throws ParseException {
        //练习：将“2020-09-08”转换为java.sql.Date
        String str = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        System.out.println(date);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        System.out.println(sqldate);
    }

}
