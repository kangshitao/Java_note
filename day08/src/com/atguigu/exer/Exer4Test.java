package com.atguigu.exer;

/**
 * @author Kangshitao
 * @date 2021年3月14日 下午5:15
 */


/*
同一个类中的方法可以互相调用（非static），不同类，则需要使用 对象.方法 的形式调用
 */
//对象数组的使用
public class Exer4Test {
    public static void main(String[] args) {
        Exer4Test test = new Exer4Test();
        Student[] students = new Student[20];  //声明Student类型的数组（对象数组），每个值都是一个对象
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();  //对数组的每个值都要实例化为对象
            students[i].number = i + 1;
            students[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);  //年级范围[1,6]
            students[i].score = (int) (Math.random() * (100 - 10 + 1) + 1); //[10,100]
        }

        System.out.println("所有学生信息");
        test.printArray(students);

        //问题一；打印3年级信息
        System.out.println("指定年级学生信息");
        test.searchState(students,3);

        //问题二：使用冒泡排序对成绩从大到小排名，并输出学生信息
        System.out.println("---------根据成绩从大到小排序---------");
        test.sortScore(students);
    }

    //打印所有学生信息
    public void printArray(Student[] stu){
        for(Student s : stu){
            s.getInfo();
        }
    }
    //获取指定年级学生信息
    public void searchState(Student[] stu, int state){
        for(Student s : stu){
            if(s.state==state) s.getInfo();
        }
    }
    //使用冒泡排序对成绩从大到小排名，并输出学生信息
    public void sortScore(Student[] stu){
        for (int i = 0; i < stu.length; i++) {
            for (int j = 0; j < stu.length - i - 1; j++) {
                if (stu[j].score < stu[j + 1].score) {
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
        printArray(stu);
    }

}

class Student {
    int number;
    int state;
    int score;

    public void getInfo() {
        System.out.println("学号：" + number + "，年级" + state + "，成绩" + score);
    }
}