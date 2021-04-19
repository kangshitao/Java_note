package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年4月2日 下午4:43
 */

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用

 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().

1、添加
    add(Object obj)
    addAll(Collection coll)
2、获取有效元素的个数
    int size()
3、清空集合
    void clear()
4、是否是空集合
    boolean isEmpty()
5、是否包含某个元素
    boolean contains(Object obj)：是通过元素的equals方法来判断是否是同一个对象
    boolean containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较。
6、删除
    boolean remove(Object obj)：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素
    boolean removeAll(Collection coll)：取当前集合的差集
7、取两个集合的交集
    boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c
8、集合是否相等
    boolean equals(Object obj)
9、转成对象数组
    Object[] toArray()

 >数组转换为集合：
    List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});

    List arr1 = Arrays.asList(new int[]{123, 456});
    System.out.println(arr1.size());//1

    List arr2 = Arrays.asList(new Integer[]{123, 456});
    System.out.println(arr2.size());//2

10、获取集合对象的哈希值
    hashCode()
11、遍历
    iterator()：返回迭代器对象，用于集合遍历


  */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());
        //集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list+"\t"+list.size());

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List<Integer> arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2
    }
}
