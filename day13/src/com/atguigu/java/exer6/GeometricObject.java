package com.atguigu.java.exer6;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午9:22
 */
public class GeometricObject {
    protected String color;
    protected double weight;


    protected GeometricObject(){};
    protected GeometricObject(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double findArea(){
        return 0.0;
    }
}
