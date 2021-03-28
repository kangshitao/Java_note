package atguigu.singletonTest;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午3:21
 */
/*
单例设计模式
1.所谓单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
2.实现方法：
    饿汉式 vs 懒汉式
3.区分饿汉式和懒汉式
    饿汉式：缺点：对象加载时间过长。
           优点：饿汉式是线程安全的
    懒汉式：优点：延迟对象的创建。
           缺点：目前的写法是线程不安全的  ——多线程内容可以对其进行修改
 */
public class SingletonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1==bank2);  //这两个对象是相同的
    }
}

//饿汉式单例模式
class Bank{
    //1.私有化类的构造器
    private Bank(){ }

    //2.内部创建类的对象
    //4.要求此对象必须是静态的
    private static Bank instance = new Bank(); //可以看成该类的一个属性，权限是私有的

    //3.提供公共的静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}