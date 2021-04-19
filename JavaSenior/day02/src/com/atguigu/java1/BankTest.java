package com.atguigu.java1;

/**
 * @author Kangshitao
 * @date 2021年3月30日 上午10:28
 */
/*
使用同步机制，将懒汉式单例模式改写为线程安全的
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
    }
}
class Bank{
    private static Bank bank = null;
    private Bank(){}
    //同步方法。方法一
//    public static synchronized Bank getBank(){ //static方法，同步监视器是当前类本身，即Bank.class
//        if(bank == null){
//            bank = new Bank();
//        }
//        return bank;
//    }
    //同步代码块
    public static Bank getBank(){
        //方式二：效率稍差
//        synchronized(Bank.class){
//            if(bank == null){
//                bank = new Bank();
//            }
//            return bank;
//        }
        //方式二改进。
        if(bank ==null) {
            synchronized (Bank.class) {
                if (bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}