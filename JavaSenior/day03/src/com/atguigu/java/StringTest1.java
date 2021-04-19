package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年3月31日 下午5:11
 */
/*
String类与其他结构之间的转换。
字符串基本数据类型、包装类
Integer包装类的public static int parseInt(String s)：可以将由“数字”字符组成的字符串转换为整型。
类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应的类方法可以将由“数字”字符组成的字符串，
    转化为相应的基本数据类型。

基本数据类型、包装类字符串
调用String类的public String valueOf(int n)可将int型转换为字符串
相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double d)、valueOf(boolean b)可由参数的相应类型到字符串的转换

字符数组字符串
String类的构造器：String(char[])和String(char[]，int offset，int length)分别用字符数组中的全部字符和部分字符创建字符串对象。

字符串字符数组
public char[] toCharArray()：将字符串中的全部字符存放在一个字符数组中的方法。
public void getChars(int srcBegin, int srcEnd, char[]dst,int dstBegin)：提供了将指定索引范围内的字符串存放到数组中的方法。

字节数组字符串 （解码）
String(byte[])：通过使用平台的默认字符集解码指定的byte数组，构造一个新的String。
String(byte[]，int offset，int length)：用指定的字节数组的一部分，即从数组起始位置offset开始取length个字节构造一个字符串对象。

字符串字节数组 (编码)
public byte[] getBytes()：使用平台的默认字符集(编码方式)将此String编码为byte序列，并将结果存储到一个新的byte数组中。
public byte[] getBytes(String charsetName)：使用指定的字符集将此String编码到byte序列，并将结果存储到新的byte数组。

编码和解码应该使用相同的字符集(编码方式)，否则出现乱码

*/
public class StringTest1 {
}
