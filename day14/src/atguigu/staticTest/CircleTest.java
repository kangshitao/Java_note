package atguigu.staticTest;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午2:43
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();  //id = 1001
        Circle c2 = new Circle();  //id = 1002
        Circle c3 =  new Circle(2);
        System.out.println(c1.getId());
        System.out.println(c2.getId());
        System.out.println(c3.getId());
        System.out.println("number of circles:"+Circle.getTotal());
    }
}

class Circle{
    private double redius;
    private int id;
    public Circle(){
        id = init++; //每次新建对象，id都+1
        total++;
    }

    public Circle(double radius){
        this();
        this.redius = radius;
    }

    private static int total;
    private static int init = 1001;  //static声明的属性被所有对象共享

    public double findArea(){
        return 3.14*redius*redius;
    }

    public double getRedius() {
        return redius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total; //通常操作static属性的方法也是static的
    }
}
