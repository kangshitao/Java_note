package com.atguigu.java2;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
/**
 * @author Kangshitao
 * @date 2021年4月1日 下午8:40
 */
/*
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 */


        import org.junit.Test;

        import java.math.BigDecimal;
        import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 *
 * @author shkstart
 * @create 2019 下午 6:23
 */
public class OtherClass {
    @Test
    public void test1() {
        System.out.println("java的version:" + System.getProperty("java.version"));
        System.out.println("java的home:" + System.getProperty("java.home"));
        System.out.println("os的name:" + System.getProperty("os.name"));
        System.out.println("os的version:" + System.getProperty("os.version"));
        System.out.println("user的name:" + System.getProperty("user.name"));
        System.out.println("user的home:" + System.getProperty("user.home"));
        System.out.println("user的dir:" + System.getProperty("user.dir"));
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        //System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.compareTo(bd2));
    }
}
