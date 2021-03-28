package atguigu.abstractExe3;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午9:42
 */
/*
编写工资系统，实现不同类型员工(多态)的按月发放工资。如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
实验说明：
（1）定义一个Employee类，该类包含：private成员变量name,number,birthday，其中birthday为MyDate类的对象；
    abstract方法earnings()；
    toString()方法输出对象的name,number和birthday。
（2）MyDate类包含:
    private成员变量year,month,day；
    toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
（3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：private成员变量monthlySalary；
    实现父类的抽象方法earnings(),该方法返回monthlySalary值；
    toString()方法输出员工类型信息及员工的name，number,birthday。
（4） 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：private成员变量wage和hour；
    实现父类的抽象方法earnings(),该方法返回wage*hour值；
    toString()方法输出员工类型信息及员工的name，number,birthday。
（5）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
    利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday。
    当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] eps = new Employee[2];
        eps[0] = new SalariedEmployee("Smith",1001,new MyDate(1991,2,14),10000);
        eps[1] = new HourlyEmployee("Jack",1002,new MyDate(1993,3,5),60,256);
        for(int i = 0; i<eps.length;i++){
            System.out.println(eps[i]);
            double salary = eps[i].earnings();
            System.out.println("Salary:"+salary);
        }
    }
}
