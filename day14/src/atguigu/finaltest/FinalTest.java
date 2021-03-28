package atguigu.finaltest;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午4:49
 */
/*
final关键字：最后的
1.final可以用来修饰的结构：类、方法、变量
2.final修饰类，此类不能被其他类所继承
    比如：String类、System类、StringBuffer类
3.final修饰方法：表明此方法不可以被重写。
    比如：Object类的getClass()方法
4.final用来修饰变量（属性和局部变量）：变量的值无法再修改，此时的“变量”被称为一个常量
    4.1 使用final修饰的属性，可以考虑赋值的位置有：
    显式初始化：final int WIDTH = 1;
    代码块中初始化: final int LEFT;
                {
                    LEFT = 1;
                }
    构造器中初始化：final int RIGHT；
                  public FinalTest{
                     RIGHT = 1；
                  }
    构造器中初始化常量，可以通过形参设置每个对象的常量值不一样，比如身份证号。
    4.2 final修饰局部变量：对于方法内部的局部变量，使用final修饰，变为常量
                          对于final修饰的形参，调用方法的时候赋值，然后就不能在方法体内对此形参重新赋值
static final用来修饰属性：全局常量
 */
public class FinalTest {
    public static void main(String[] args) {
    }
}

final class FinalA{

}
