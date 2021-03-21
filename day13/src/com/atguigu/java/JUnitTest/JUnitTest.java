package com.atguigu.java.JUnitTest;

import org.junit.Test;

import java.util.Date;

/**
 * @author Kangshitao
 * @date 2021年3月19日 上午11:18
 */

/*
Java中的JUnit单元测试
步骤：
1.
2.创建Java类，用于单元测试，即创建测试类。(可以在被测试的类中，右键自动生成测试类。右键—— go to —— test —— creat test class)
    此类的要求：①类是public的 ②有公共的无参构造器
3.此类中声明单元测试方法。
    此时的单元测试方法要求：public，无返回值和形参
4.此单元测试方法上需要声明注解@Test，并在单元测试类中导入import org.junit.Test;
5.声明好单元测试方法以后，就可以在方法体内测试相关的代码
6.写完代码以后，运行测试方法。
  >如果执行以后没有异常，绿条，Tests passed
  >如果有异常，红色，显示异常信息
 */
public class JUnitTest {

    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));

    }

    @Test
    public void testToString(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.toString());

    }
}
