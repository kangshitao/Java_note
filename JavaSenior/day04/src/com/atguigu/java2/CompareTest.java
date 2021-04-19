package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kangshitao
 * @date 2021年4月1日 下午5:24
 */
/*
使用Comparable/Comparator这两个接口，比较对象的大小。
一、Comparable接口---自然排序
    1.String、包装类等，实现了Comparable接口，重写了compareTo(obj)方法，
    2.String、包装类重写了compareTo(obj)方法后，进行了从小到大的排列
    3.重写compareTo(obj)方法规则（从小到大排序）：
        this>obj,返回正整数
        this<obj,返回负整数
        this=obj,返回0
        >如果想从大到小排序，
    4.对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，重写compareTo方法，在compareTo方法中指明如何排序

二、Comparator接口---定制排序
    1.当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
        或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
        那么可以考虑使用Comparator的对象来排序，强行对多个对象进行整体排序的比较。
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；
        如果返回0，表示相等；返回负整数，表示o1小于o2。
    3.可以将Comparator传递给sort方法（如Collections.sort或Arrays.sort），从而允许在排序顺序上实现精确控制。
    4.还可以使用Comparator来控制某些数据结构（如有序set或有序映射）的顺序，或者为那些没有自然顺序的对象collection提供排序
三、二者的对比：
    Comparable接口的方式一旦指定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
    Comparator接口属于临时性的比较。
 */
public class CompareTest {
    @Test
    public void test(){
        String[] str = new String[]{"DD","BB","AA","CC"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }
    @Test
    public void test2(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("A",12);
        goods[1] = new Goods("B",21);
        goods[2] = new Goods("C",15);
        goods[3] = new Goods("D",2);
        Arrays.sort(goods); //排序，此时调用的是重写的方法进行比较
        System.out.println(Arrays.toString(goods));
    }
    @Test
    public void test3(){
        String[] str = new String[]{"DD","BB","AA","CC"};
        //实现Comparator接口，自定义排序规则。需要重写compare方法
        Arrays.sort(str, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }else{
                    throw new RuntimeException("类型错误");
                }

            }
        });
        System.out.println(Arrays.toString(str));
    }
}
class Goods implements Comparable{
    private String name;
    private int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //根据价格从小到大排序
    public int compareTo(Object obj){
        if(obj instanceof Goods){
            Goods good = (Goods) obj;
            if(this.price > good.price)
                return 1;
            else if(this.price< good.price)
                return -1;
            else
                return 0;
        }
        else{
            throw new RuntimeException("类型错误");
        }
    }
}
