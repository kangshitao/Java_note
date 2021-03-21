package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

import javax.xml.transform.stream.StreamSource;

/**
 * @author Kangshitao
 * @date 2021年3月17日 下午2:53
 */
/*
CustomerView为主模块，负责菜单的显示和处理用户操作
属于MVC的view，视图层。
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);  //创建最大包含10个客户对象的CustomerList对象

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

    public  CustomerView(){ //构造函数中添加默认的一个客户
        Customer customer = new Customer("张三",'男',23,
                "12345678901","zs@gmail.com");
        customerList.addCustomer(customer);
    }

    /**
     * 显示主菜单，响应用户输入。
     * 根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
     */
    public void enterMainMenu() {
        boolean loopFlag = true; //判断是否退出
        while (loopFlag) {
            System.out.println("\n-------------------客户信息管理软件-------------------");
            System.out.println("                       1 添加客户");
            System.out.println("                       2 修改客户");
            System.out.println("                       3 删除客户");
            System.out.println("                       4 客户列表");
            System.out.println("                       5 退出");
            System.out.println("                       请选择(1-5)");
            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        loopFlag = false;
                    }
            }
        }
    }

    /**
     * 添加客户
     */
    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("-----------------客户已满，添加失败---------------------");
        }
    }

    /**
     * 修改客户
     */
    private void modifyCustomer() {
        Customer customer;
        int input;
        while(true){
            System.out.print("请选择待修改客户编号(-1退出)：");
            input = CMUtility.readInt();
            if(input == -1){
                return;  //退出修改
            }
            customer = customerList.getCustomer(input-1);
            if(customer==null) {
                System.out.println("无法找到指定客户！");
            }else{ //为了显得不臃肿，将修改信息的代码转到while循环外面写。
                break;
            }
        }
        //如果程序执行到这里，说明找到了客户。
        System.out.print("姓名(" + customer.getName() + ")：");
        //如果没有输入，则默认还是原来的name
        String name = CMUtility.readString(10, customer.getName());
        System.out.print("性别(" + customer.getGender() + ")：");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄(" + customer.getAge() + ")：");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话(" + customer.getPhone() + ")：");
        String phone = CMUtility.readString(15, customer.getPhone());
        System.out.print("邮箱(" + customer.getEmail() + ")：");
        String email = CMUtility.readString(15, customer.getEmail());
        Customer newCus = new Customer(name,gender,age,phone,email);
        boolean isReplaced = customerList.replaceCustomer(input-1,newCus);
        if(isReplaced){
            System.out.println("---------------------修改完成---------------------");
        }else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }

    /**
     * 删除客户
     */
    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        int input;
        while(true){
            System.out.print("请选择待删除客户编号(-1退出)：");
            input = CMUtility.readInt();
            if(input == -1){
                return;  //退出删除
            }
            Customer customer = customerList.getCustomer(input-1);
            if(customer==null) {
                System.out.println("无法找到指定客户！");
            }else{ //为了显得不臃肿，将代码转到while循环外面写。
                break;
            }
        }
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete == 'Y') {
            boolean isSuccess = customerList.deleteCustomer(input-1);
            if(isSuccess) System.out.println("删除成功");
            else System.out.println("删除失败");
        }
    }

    /**
     * 客户列表
     */
    private void listAllCustomers() {
        System.out.println("----------------------------客户列表----------------------------\n");
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            Customer[] cust = customerList.getAllCustomers();
            for(int i = 0; i<total; i++){
                System.out.println((i+1)+"\t\t"+cust[i].getName()+"\t"+cust[i].getGender()+
                        "\t\t"+cust[i].getAge()+"\t\t"+cust[i].getPhone()+"\t"+
                        cust[i].getEmail()+"\n");
            }
        }
        System.out.println("---------------------------客户列表完成----------------------------\n");
    }
}
