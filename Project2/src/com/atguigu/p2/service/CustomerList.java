package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;//使用别的包下的类就需要导入

/**
 * @author Kangshitao
 * @date 2021年3月17日 下午2:53
 */
/*
CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
属于MVC模式的Controller，控制层，
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0; //记录已保存客户对象的个数

    /**
     * 构造器，用来初始化customers数组
     *
     * @param totalCustomer 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * 将参数customer添加到数组中最后一个客户对象记录之后
     *
     * @param customer 指定要添加的客户对象
     * @return 添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer) {
        if (this.total >= customers.length) {
            return false;
        }
        this.customers[this.total] = customer;
        this.total++;
        return true;
    }

    /**
     * 用参数customer替换数组中由index指定的对象
     *
     * @param index    指定所替换对象在数组中的位置，从0开始
     * @param customer 指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
     * 从数组中删除参数index指定索引位置的客户对象记录
     *
     * @param index 指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1]; //将index之后的数组值前移。
        }
        customers[total - 1] = null; //将前移后剩下的最后一个置空。
        total--;
        // customers[--total]; 以上两行也可以简写为一行
        return true;
    }

    /**
     * 返回数组中记录的所有客户对象
     *
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     */
    public Customer[] getAllCustomers() {
        Customer[] allCus = new Customer[total];  //新建数组，保存所有用户信息。因为原数组可能有空值
        for (int i = 0; i < total; i++) {
            allCus[i] = customers[i];
        }
        return allCus;
    }

    /**
     * 返回参数index指定索引位置的客户对象记录
     *
     * @param index index指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * @return 返回当前客户数量
     * 获取存储的客户的数量
     */
    public int getTotal() {
        return total;
    }
}
