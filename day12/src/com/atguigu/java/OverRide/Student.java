package com.atguigu.java.OverRide;

/**
 * @author Kangshitao
 * @date 2021年3月18日 上午11:04
 */
public class Student extends Person{
    private String major;
    private int id = 1001;
    //这里的id和父类的id名字一样，如果Student类中想调用父类的id，必须使用super关键字

    public Student(){}

    public Student(String major) {
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name,age);  //通过super调用父类的构造器
        this.major = major;
    }

    public void study(){
        System.out.println("study");
    }

    public void eat(){  //这里的eat重写了父类的eat方法
        System.out.print("super test:");
        super.eat();  //通过super关键字，调用父类的eat方法。
        System.out.println("study eat");
    }

    public void show(){
        //通过super关键字调用父类的属性id。如果不写，默认是本类的id。
        System.out.println("student number:"+id+"\t"+"ID:"+super.id);
        //这里的this.id 和 id相同。

        System.out.println("name:"+getName()+"\t"+"age:"+super.getAge());
        //getName和getAge是父类中方法，和子类没有重名，因此可以省略super关键字
    }
}
