package exceptionalhandling;

/**
 * @author Kangshitao
 * @date 2021年3月24日 下午4:25
 */
/*
自定义异常类
步骤：
    1.继承于现有的异常结构：RuntimeException、Exception。
    2.提供全局常量：serialVersionUID
    3.提供重载的构造器
 */
public class MyException extends RuntimeException{
    static final long serialVersionUID = -1234567890L;

    public MyException(){}
    public MyException(String msg){
        super(msg);
    }
}
