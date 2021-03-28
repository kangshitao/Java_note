package atguigu;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午7:46
 */

/*
abstract关键字的使用。
1.abstract：抽象的
2.abstract可以用来修饰类、方法
3.abstract修饰类：抽象类
    >抽象类不能实例化对象，可以使用多态。
    >抽象类中一定有构造器，便于子类实例化时调用。
    >开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作

4.abstract修饰方法：抽象方法
    >抽象方法只有方法的声明，没有方法体。
    >包含抽象方法的类，一定是抽象类；但是，抽象类中是可以没有抽象方法的。
    >只有子类实现（类似于重写）了父类中的所有抽象方法(包括直接父类和间接父类的所有抽象方法)，此子类才可以实例化。
     如果子类没有实现父类中所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰。
5.abstract使用上的注意点：
    5.1：abstract不能用来修饰属性、构造器
    5.2：因为抽象方法必须要被重写，所以abstract不能用来修饰private方法、static方法、final的方法。
         进而，abstract也不能修饰final的类。
6.匿名子类：
    比如抽象类Person，创建一个匿名子类的对象p
    Person p = new Person() {  //匿名子类，需要重写所有抽象方法
            @Override
            public void eat() {
                System.out.println("匿名eat");
            }
            @Override
            public void breath() {
                System.out.println("匿名breath");
            }
        };


 */
public class AbstractTest {
    public static void main(String[] args) {
        Person p = new Person() { //创建一个匿名子类的对象p
            @Override
            public void eat() {
                System.out.println("匿名eat");
            }
            @Override
            public void breath() {
                System.out.println("匿名breath");
            }
        };
        method(p);
    }
    public static void method(Person p){ //多态
        p.eat();
        p.breath();
    }
}

abstract class Creature{
    public abstract void breath();
}
abstract class Person extends Creature{
    String name;
    int age;

    public Person(){ }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //不是抽象方法，有{}就说明有方法体。
    //public void eat(){ }

    //抽象方法，没有方法体
    public abstract void eat();
}

class Student extends Person{
    public Student(){
        super();
    }
    public Student(String name, int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("student eat");
    }
    public void breath(){ //非抽象类的子类，必须重写直接父类和间接父类的所有抽象方法。
        System.out.println("student breath");
    }
}