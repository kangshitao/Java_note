package atguigu.innerclass;

import java.util.Queue;

/**
 * @author Kangshitao
 * @date 2021年3月23日 下午4:08
 */
/*
类的内部成员之五：内部类
1.Java中允许将一个类A声明在另一个类B中，则类A就是内部类，B为外部类
2. 内部类分类：成员内部类（静态，非静态） vs 局部内部类(方法内、代码块内、构造器内)
3.成员内部类：
    一方面：作为外部类的成员：
        >调用外部类的结构
        >可以被static修饰
        >可以被四种不同的权限修饰

    另一方面：作为一个类：
        >类内可以定义属性、方法、构造器等，和一般的类定义相同
        >可以被final修饰，表示不可以被继承。不用final则可以被继承
        >可以被abstract修饰
4。内部类的用法：
    4.1 如何实例化成员内部类的对象
        >静态成员内部类：“外部类.内部类 对象名 = new 外部类.内部类();”
        >非静态成员内部类：先创建外部类对象p，然后“外部类.内部类 对象名 = p.new 内部类();”
    4.2 如何在成员内部类中区分调用外部类的结构
        "this.属性"表示内部类的属性，"外部类.this.属性"表示调用外部类的属性
    4.3 开发中局部内部类的使用
        例：见public Comparable getComparable(){}
5.注意：内部类在编译以后，也会生成字节码文件：
    成员内部类：外部类$内部类名.class，比如Person$Brain.class
    局部内部类：外部类$数字 内部类名.class Person$1AA.class

6.局部内部类的方法中，如果想调用 声明此局部内部类 的方法里定义的局部变量的话，要求此局部变量是final的。
    JDK 1.7 及之前版本，要求显式声明为final
    JDK 1.8及以后，可以省略final关键字，默认就是final的
 */
public class InnerClass {
    public static void main(String[] args) {
        Person.Brain brain = new Person.Brain(); //创建静态成员内部类对象

        //创建非静态成员内部类对象
        Person p = new Person();
        Person.Heart heart = p.new Heart();

    }
}
class Person{
    //静态成员内部类
    static class Brain{

    }
    //成员内部类
    class Heart{ }

    public void method(){
        int num = 10;
        class AA{
            int aa = num;
        } //局部内部类
        //num = 20; //编译错误。局部内部类调用了num，则num是final的，不可以被修改。
    }
    {
        class BB{} //局部内部类
    }
    public Person(){
        class CC{} //局部内部类
    }

    public Comparable getComparable(){  //返回一个实现了Comparable接口的类的对象
        //方式一
        /*
        class MyComparable implements Comparable{
            public int compareTo(Object o){
                return 0;
            }
        }
        return new MyComparable();
        */

        //方式二：使用匿名实现类，返回匿名实现类的匿名对象
        return new Comparable() {
            @Override
            public int compareTo(Object o) {return 0;}
        };
    }
}
