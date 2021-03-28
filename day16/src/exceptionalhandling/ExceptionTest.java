package exceptionalhandling;

/**
 * @author Kangshitao
 * @date 2021年3月24日 上午11:22
 */
/*
一、异常的处理：抓抛模型
过程一：“抛”：执行过程中，一旦出现异常，会在异常代码处生成一个对应异常类的对象。并将此对象抛出。
        一旦抛出对象以后，其后的代码不再执行。
        关于异常对象的产生：①系统自动生成的异常对象。②手动生成一个异常对象，并抛出(throw)，注意throw和throws的区别。

过程二：“抓”：可以理解为异常的处理方式：①try-catch-finally ②throws

二、异常处理方式一：
    try-catch-finally的使用：
    try{
        //可能出现异常的代码
    }catch(异常类型1 变量名1){
        //处理异常的方式1
    }catch(异常类型2 变量名2){
        //处理异常的方式2
    }catch(异常类型3 变量名3){
        //处理异常的方式3
    }
    ......
    finally{
        //一定会执行的代码
    }

说明:
1.finally是可选的。try-catch-finally结构可以嵌套
2.使用try将可能出现异常的代码包装起来，一旦出现异常，会生成一个对应异常类的对象，根据此对象的类型，去catch中匹配
3.try中的异常对象匹配到某个catch时，就进入catch中处理，处理完成后，跳出try-catch结构(没有finally时)，继续执行其后的代码
4.catch中的异常类型如果没有子父类关系，则多个catch无关顺序。
  如果多个catch的异常类型，有子父类关系，需要将子类写在父类的前面，否则出错。
5.常用的异常对象处理的方式：①Sting getMessage()  ② printStackTrace()
6.try结构中声明的变量，在try结构外面不能调用。可以将变量声明在外面。

7.finally的使用：finally是可选的。
  7.1  finally中声明的是一定会被执行的代码。即使catch中又出现异常、try中有return语句、catch中有return语句，也会执行。
  7.2  像数据库连接，输入输出流，网络编程Socket等资源，JVM不能自动回收，需要手动进行资源的释放。此时的资源释放，需要声明在finally中


如何看待代码中的编译时异常和运行时异常？
体会1：在使用try-catch-finally处理编译时异常时，使程序在编译时不报错，但运行时仍可能报错。
      相当于使用try-catch-finally将编译时可能出现的异常，延迟到运行时出现。
体会2：由于运行时异常比较常见，并且Java能够自动捕获，因此，通常不针对运行时异常编写try-catch-finally
      针对编译时异常，一定要考虑异常处理。
面试题：
1.final，finally，finalize的区别。
2.throw、throws区别
    >throw表示手动抛出一个异常类的对象，是生成异常对象的过程，声明在方法体内。
    >throws属于异常处理的一种方式，声明在方法声明处。
3.Collection、Collections
4.String、StringBuffer、StringBuilder
5.ArrayList、LinkedList
6.HashMap、LinkedHashMap
------
7.抽象类、接口的区别
8.==、equals()的区别
9.sleep()、wait()的区别
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
        et.test1();
    }
    public void test1(){
        String s = "123";
        s = "abc";
        try {
            int num = Integer.parseInt(s);
            System.out.println("postion 1");
        }catch(NumberFormatException e){
            System.out.println("出现数值转换异常");
            //调用方法
            //String getMessage()
            System.out.println(e.getMessage());
            //printStackTrace()
            e.printStackTrace();

        }catch(NullPointerException e){
            System.out.println("出现空指针异常");
        }finally {
            System.out.println("finally");
        }
        System.out.println("postion 2");
    }
}
