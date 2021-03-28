package com.atguigu.team.domain;

/**
 * @author Kangshitao
 * @date 2021年3月28日 上午11:46
 */
public class NoteBook implements Equipment {
    private String model;  //机器型号
    private double price;  //

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return model + "(" + price + ")";
    }
}
