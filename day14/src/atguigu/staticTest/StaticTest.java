package atguigu.staticTest;

/**
 * @author Kangshitao
 * @date 2021年3月22日 上午11:05
 */
/*
static关键字的使用
1.static：静态的
2.static可以用来修饰：属性、方法、代码块、内部类
3.static修饰属性：称为静态变量（类变量），
    3.1属性：按照是否使用static，分为静态属性vs非静态属性(实例变量)
    实例变量：当创建了类的多个对象，每个对象都独立地拥有一套类中的非静态变量。实例变量归具体的某个对象所有。
             修改其中一个对象的非静态属性，不会导致其他对象同样的属性被修改。
    静态变量：当创建了类的多个对象，多个对象共享一个静态变量，通过一个对象修改此属性，导致其他对象调用时也是被修改后的属性值。
    3.2 static修饰属性的其他说明：
        ①静态变量随着类的加载而加载。可以通过"类.静态变量“的方式调用
        ②静态变量的加载早于对象的创建。
        ③由于类只会加载一次，则静态变量在内存中只会存在一份，保存在方法区的静态域中。
        ②     类变量       实例变量
        类      yes          no
        对象    yes          yes
    3.3 静态变量举例：System.out；Math.PI

4.static修饰方法：静态方法
    ①随着类的加载而加载，也可以通过"类.方法"调用。
    ②     静态方法       非静态方法
    类      yes          no
    对象    yes          yes
    ③静态方法中，只能直接调用静态方法或属性。（考虑生命周期，因为静态方法先于非静态方法加载），可以通过创建对象调用非静态方法和属性。
     非静态方法，既可以调用静态方法，也可以调用非静态方法。
5.注意点：
    >静态方法内，不能使用this、super关键字。
    >关于静态属性和静态方法的使用，都可以从生命周期的角度去解释

6.开发中如何确定属性是否要声明为static的？
    >属性可以被多个对象共享，不会随着对象不同而不同的，用static修饰，比如银行利率
    >类中的常量常常声明为static(static final)，但不是必须的

  开发中如何确定方法是否要声明为static的？
    >操作静态属性的方法通常设置为static的
    >工具类中的方法习惯上声明为static，比如Math、Arrays、Collections
 */
public class StaticTest {
    public static void main(String[] args) {
        System.out.println("-------直接通过类名调用：");
        System.out.println(Chinese.nation);
        Chinese.show();

        System.out.println("-------通过对象调用：");
        Chinese c1 = new Chinese();
        c1.name = "Smith";
        c1.age = 12;
        Chinese c2 = new Chinese();
        c2.name = "Jack";
        c2.age = 15;
        c1.nation = "China";
        c2.nation = "CHN";
        System.out.println(c2.nation);
        c1.show();
    }
}

class Chinese{
    String name;
    int age;
    static String nation;
    public void eat(){
        System.out.println("eat");
    }
    public static void walk(){
        System.out.println("walk");
    }
    public void info(){
        System.out.println("info");
        show(); //非静态方法可以调用静态方法和属性
    }
    public static void show(){
        //静态方法不能直接调用非静态方法和属性
        //eat();
        //age = 12;

        //静态方法可以通过构建对象，调用非静态方法和属性
        Chinese c = new Chinese();
        c.eat();
        int a = c.age;

        //静态方法可以直接调用静态方法和属性
        walk();
        System.out.println("I'm "+nation);  //可以调用静态属性
    }
}