package exceptionalhandling;

/**
 * @author Kangshitao
 * @date 2021年3月24日 上午10:50
 */
/*
异常处理
Java中的异常分为两类：
    Error：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。
            比如：StackOverflowError和OOM。一般不编写针对性的代码进行处理。
    Exception:其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如：
            空指针访问
            试图读取不存在的文件
            网络连接中断
            数组角标越界
一、异常体系结构：
java.lang.Throwable
    |-----java.lang.Error: 一般不编写针对性的代码进行处理
    |-----java.lang.Exception:可以进行异常处理
        |-----编译时异常(checked)
            |-----IOException
                |-----FileNotFoundException
            |-----ClassNotFoundException
        |-----运行时异常(unchecked，RuntimeException)
            |-----NullPointerException
            |-----ArrayIndexOutOfBoundException
            |-----ClassCastException
            |-----NumberFormatException
            |-----InputMismatchException
            |-----ArithmaticException

面试题：常见的异常都有哪些：

 */
public class ErrorTest {
}
