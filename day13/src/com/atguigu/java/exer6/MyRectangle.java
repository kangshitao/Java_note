package com.atguigu.java.exer6;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午9:24
 */
public class MyRectangle extends GeometricObject{
    private double width;
    private double height;
    public MyRectangle(double width,double height,String color,double weigh){
        super(color,weigh);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double findArea(){
        return width*height;
    }
}
