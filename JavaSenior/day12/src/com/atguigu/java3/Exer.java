package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Kangshitao
 * @date 2021年4月15日 下午7:33
 */
public class Exer {
    @Test
    public void test1(){
        //练习，获取姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        //方式一
        employees.stream().filter(e->e.getName().length()>3).forEach(e->System.out.println(e.getName()));
        //方式二
        employees.stream().map(e->e.getName()).filter(name->name.length()>3).forEach(System.out::println);
    }
    @Test
    public void test2(){
        //排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->e1.getAge()-e2.getAge()).forEach(System.out::println);
    }
    @Test
    public void test3(){
        //匹配和查找
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println(employees.stream().min((e1,e2)-> Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println(employees.stream().min((e1,e2)-> (int) (e1.getSalary()-e2.getSalary())));
    }
    @Test
    public void test4(){
        //规约
        //exercise 1,求1到10的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        //求每个职工的工资和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(e -> e.getSalary()).reduce((a, b) -> a + b);
        System.out.println(reduce1);

    }
}
