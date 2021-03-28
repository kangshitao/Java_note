package atguigu.interfacetest;

/**
 * @author Kangshitao
 * @date 2021年3月23日 下午2:51
 */
/*
JDK8: 除了能够定义全局常量和抽象方法之外，还可以定义静态方法、默认方法(default修饰)
1.接口中定义的静态方法，只能使用接口调用.
2.通过实现类的对象，可以调用接口的默认方法。默认方法可以被重写，但不是必须的。抽象方法必须被重写
3.如果子类(或实现类)继承的父类和实现的接口中声明了同名同参的方法，
  当子类没有重写的时候，默认调用的是父类的方法→类优先原则。
4.如果类实现了多个接口，这多个接口中定义了同名同参的默认方法，实现类必须重写此方法，否则报错。→接口冲突
5.实现类调用接口中的default方法：“接口名.super.方法名”
 */
public class InterfaceJDK8 {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        CompareA.method1();  //接口的静态方法，只能使用接口调用
        s.method2(); //通过实现类的对象，可以调用接口的默认方法。默认方法可以被重写，但不是必须的
        s.method3();
    }
}

interface CompareA{
    //静态方法
    public static void method1(){
        System.out.println("CompareA:method1");
    }
    //默认方法。public关键字可以省略，权限还是public
    public default void method2(){
        System.out.println("CompareA:method2");
    }
    //抽象方法
    abstract void method3();
}


class SuperClass{
    public void method2(){
        System.out.println("SuperClass:method2");
    }
}

class SubClass extends SuperClass implements CompareA{
//
//    @Override
//    public void method2(){
//        System.out.println("Subclass:method2");
//    }
    @Override
    public void method3() {
        System.out.println("Subclass:method3");
        CompareA.super.method2(); //调用接口的默认方法
    }
}