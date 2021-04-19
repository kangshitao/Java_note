package com.atguigu.java2;

/**
 * @author Kangshitao
 * @date 2021年3月30日 下午3:27
 */
/*
线程通信的应用：生产者/消费者问题。
 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 店员最多只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
 如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，
 如果店中有产品了再通知消费者来取走产品。

分析：多线程、有共享数据，三种方式解决线程的安全问题，涉及到线程通信问题

 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer1 = new Customer(clerk);
        Customer customer2 = new Customer(clerk);
        new Thread(productor,"生产者").start();
        new Thread(customer1,"消费者1").start();
        new Thread(customer2,"消费者2").start();
    }
}

class Clerk{
    private int numberPro = 0;
    public synchronized void productPro(){
        if(numberPro<20){
            numberPro++;
            System.out.println(Thread.currentThread().getName()+"生产产品"+numberPro);
            notify(); //唤醒消费者线程
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void customPro(){
        if(numberPro>0){
            System.out.println(Thread.currentThread().getName()+"消费产品"+numberPro);
            numberPro--;
            notify();  //唤醒生产者进程
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor implements Runnable{
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productPro();
        }
    }
}
class Customer implements Runnable{
    private Clerk clerk;
    public Customer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.customPro();
        }
    }
}