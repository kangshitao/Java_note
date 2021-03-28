package atguigu.maintest;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午3:48
 */
/*
main()方法的使用说明：
1.main()方法是程序的入口
2.main()方法也是一个普通的静态方法，也可以通过“类名.main()”的方式调用
3.main()方法有参数，所以也可以作为与控制台交互的方式
 */
public class MainTest {
    MainTest mt = new MainTest();
    public static void main(String[] args){
        Main.main(new String[10]); //调用Main类的main方法
    }
}
class Main{
    public static void main(String[] args) {
        args = new String[10];
        for (int i = 0; i<args.length;i++){
            args[i] = "args_" + i;
            System.out.println(args[i]);

        }
    }
}