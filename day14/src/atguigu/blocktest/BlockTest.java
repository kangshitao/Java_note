package atguigu.blocktest;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午4:05
 */
/*
类的成员之四：代码块（初始化块）
1.作用：用来初始化类、对象
2.代码块没有名，主动执行
3.代码块如果有修饰符，只能是static。
4.分类：静态代码块和非静态代码块
5.静态代码块：
    >内部可以有输出语句
    >随着类的加载而执行，只会执行一次
    >作用：初始化类的信息，比如对类变量赋值。
    >一个类中可以定义多个静态代码块，按照先后顺序执行。

6.非静态代码块：
    >内部可以有输出语句
    >随着对象的创建而执行，每创建一次就执行一次。非静态代码块先于构造器执行
    >作用：可以在创建对象时，对对象的属性进行初始化
    >一个类中可以定义多个非静态代码块，按照先后顺序执行。
7.静态代码块和静态方法类似，只能直接调用静态方法和属性
属性赋值的方式：
a.默认初始化
b.显式初始化
c.构造器初始化
d.创建对象以后，通过对象调用并赋值
e.代码块中赋值
赋值顺序：a-b和e(b和e按照代码顺序执行)-c-d

有继承关系的类中，执行特点：由父及子，静态先行
 */
public class BlockTest {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.number);

    }
    static { //先加载BlockTest类，再加载Person类
        System.out.println("BlockTest block");
    }
}

class Person{
    String name;
    int age;
    static String desc = "I'm a person";
    public Person(){}
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("eat");
    }

    //非静态代码块
    {
        System.out.println("Person block");
    }
    //静态代码块
    static{
        System.out.println("Person static block");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person{
    int number;
    public Student(){
        number = 1;
        System.out.println("Student constructor");
    }
    {
        number = 2;
        System.out.println("Student block");
    }
    static {
        System.out.println("Student static block");
    }
}