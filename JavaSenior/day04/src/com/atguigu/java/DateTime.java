package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午8:37
 */
/*
JDK 8.0 之前，日期和时间的API：
a.java.lang.System类中的public static long currentTimeMillis()
b.java.util.Date 和 java.sql.Date类
c.java.text.SimpleDateFormat
d.Calendar


1.java.lang.System类中的public static long currentTimeMillis()
    用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。称为时间戳

2.Date类有两个，还是子父类的关系
java.util.Date
    |---java.sql.Date类   --对应数据库中的日期对象

  对于util的Date
  a.两个构造器的使用
    >Date date = new Date(); 创建了一个对应当前时间的Date对象
    >Date date = new Date(1617195044549L); 创建指定毫秒数的Date对象
  b.两个方法的使用
    >toString():显示当前的年、月、日、时、分、秒
    >getTime()：获取当前Date对象的时间戳(毫秒数)

  对于sql.Date
  c. new java.sql.Date(1617195044549L),没有空参构造器
  d. 如何将java.util.Date对象转换为java.sql.Date对象：
       将util.Date获取的时间戳作为sql.Date构造器的参数，新建sql.Date对象
       java.sql.Date date = new java.sql.Date(new util.Date().getTime());


 */
public class DateTime {
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);

        //构造器1
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        //构造器2.
        System.out.println(new Date(1617195044549L).toString());

        //sql.Date的构造器
        System.out.println(new java.sql.Date(1617195044549L).toString());

        //如何将java.util.Date对象转换为java.sql.Date对象：
    }
}
