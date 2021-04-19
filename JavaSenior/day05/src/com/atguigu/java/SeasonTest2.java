package com.atguigu.java;

/**
 * @author Kangshitao
 * @date 2021年4月2日 上午11:02
 */
/*
方式二：使用enum关键字定义枚举类
说明：定义的枚举类默认继承于java.lang.Enum类，Enum类重写了toString方法，默认打印对象的名字
 */
public class SeasonTest2 {
    public static void main(String[] args) {
        //toString方法：
        System.out.println(Season2.SPRING);
        System.out.println(Season2.class.getSuperclass()); //父类是Enum类

        //values方法
        Season2[] values = Season2.values();
        for(Season2 i: values){
            System.out.println(i);
//            i.info();
        }

        //valueOf(String str)方法,返回枚举类中，对象名是str的枚举类对象
        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter.toString());

        //枚举类在switch中的应用
        Season2 season = Season2.SPRING;
        switch (season){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
enum Season2 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING ("春天","春暖花开"){
        public void info(){
            System.out.println("spring");
        }
    },
    SUMMER ("夏天","夏日炎炎"){
        public void info(){
            System.out.println("summer");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        public void info(){
            System.out.println("autumn");
        }
    },
    WINTER("冬天","冰天雪地"){
        public void info(){
            System.out.println("winter");
        }
    };
    //2.声明对象属性为private final
    private final String seasonName;
    private final String seasonDec;
    //3.构造器应该是private的，enum里面可以省略
     Season2(String seasonName,String seasonDec){
        this.seasonName = seasonName;
        this.seasonDec = seasonDec;
    }
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

//    @Override
//    public String toString() {
//        return "com.atguigu.java.Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDec='" + seasonDec + '\'' +
//                '}';
//    }
}

interface Info{
    void info();
}
