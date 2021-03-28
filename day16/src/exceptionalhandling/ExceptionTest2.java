package exceptionalhandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Kangshitao
 * @date 2021年3月24日 下午3:41
 */
/*
异常处理方法二：throws + 异常类型
1."throws + 异常类型"写在方法声明处，指明此方法执行时，可能会抛出的异常类型。
    一旦当方法体执行时出现异常，仍会在异常代码处生成一个异常类对象，此对象满足throws后异常类型时，就会被抛出(方法的调用者)。
    异常代码的后续代码不会被执行。
2.try-catch-finally的方式真正地将异常处理掉了。
  throws的方式只是将异常抛给了方法的调用者，没有真正地将异常处理掉。
3.对于重写的方法，子类重写的方法抛出的异常不大于父类被重写的方法抛出的异常类型。

4.如何选择两种方式：
    1.如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法不能使用throws，如果有异常只能使用try-catch-finally的方式，
    2.如果执行的方法a中先后调用了另外的几个递进关系的方法，建议这几个方法使用throws处理异常，而方法a使用try-catch-finally。


 */
public class ExceptionTest2 {
    public static void main(String[] args) {
        ExceptionTest2 t = new ExceptionTest2();
        try{
            t.method2();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void method2() throws FileNotFoundException, IOException{
        method();
    }
    public void method() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while(data != -1){
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();
    }
}
