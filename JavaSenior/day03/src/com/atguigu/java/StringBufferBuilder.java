package com.atguigu.java;

import org.junit.Test;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午5:55
 */

public class StringBufferBuilder {
    /*
    1.String、StringBuffer、StringBuilder的异同：
    String： 1.0 不可变的字符序列；底层使用char[]来保存
    StringBuffer：1.0 可变的字符序列；线程安全的，效率低；底层使用char[]来保存
    StringBuilder：JDK 5.0新增 可变的字符序列；线程不安全，效率高；底层使用char[]来保存
    >>>JDK9.0之后，都改为了byte[]数组
    > 效率从高到低排列：StringBuilder > StringBuffer > String

    2.String、StringBuffer、StringBuilder三者之间的相互转换：
        >String→StringBuffer、StringBuilder，直接调用两者的构造器，StringBuffer sb = new StringBuffer(str);
        >StringBuffer、StringBuilder→String：
            a. 调用两者的toString()方法
            b. 调用String的构造器。String str = new String(sb);

    3.源码分析：
    String str = new String();  //new char[0]
    String str1 = new String("abc");//new char[]{'a','b','c'}

    StringBuffer sb = new StringBuffer();  //new char[16],底层创建了一个长度为16的数组，即new value[16];
    sb.append('a');  //value[0] = 'a';
    StringBuffer sb = new StringBuffer("abc"); // char[] value = new char["abc".length()+16];

    //问题1. sb2.length()是0，返回的不是value的长度
    //问题2. 扩容问题：如果添加的数据，底层数组装不下，需要扩容底层的数组。
            默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中
     > 开发中，为了提高效率，建议使用StringBuffer(int capacity) 或 StringBuilder(int capacity)
                指定容量，尽量避免自动扩容


    */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());  //0
        StringBuffer sb3 = new StringBuffer();
        String s = null;
        sb3.append(s); //append方法可以将null当作字符串添加进去
        System.out.println(sb3);
        System.out.println(sb3.length());
        //StringBuffer sb4 = new StringBuffer(null); //构造的时候不行
    }

    /*
    二、StringBuffer/StringBuilder的常用方法（二者方法相同）

    String Buffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接。如果参数是null，会被当成字符串添加进去
    String Buffer delete(int start,int end)：删除指定位置的内容
    String Buffer replace(int start,int end,String str)：把[start,end)位置替换为str
    String Buffer insert(int offset,xxx)：在指定位置插入xxx
    String Buffer reverse()：把当前字符序列逆转
    public int indexOf(String str)
    public String substring(int start,int end)
    public int length()
    public char charAt(int n )
    public void setCharAt(int n ,char ch)

    总结：
    增：
    删：
    改：
    查：
    插入：
    长度：
    遍历：
     */
}
