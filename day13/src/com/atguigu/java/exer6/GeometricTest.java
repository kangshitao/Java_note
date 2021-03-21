package com.atguigu.java.exer6;

/**
 * @author Kangshitao
 * @date 2021年3月18日 下午9:25
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c = new Circle(2,"red",1);
        MyRectangle t = new MyRectangle(3,4,"white",3);
        test.displayGeometricObject(c);
        test.displayGeometricObject(t);
        test.equalsArea(c,t);
    }
    public void equalsArea(GeometricObject geo1,GeometricObject geo2){
        if(geo1.findArea() == geo2.findArea()){
            System.out.println("Area is equal");
        }else{
            System.out.println("Area isn't equal");
        }
    }
    public void displayGeometricObject(GeometricObject geo){
        System.out.println("Area:"+geo.findArea());
    }
}
