package com.atguigu.exe;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Kangshitao
 * @date 2021年4月9日 下午3:43
 */
public class FileExe {
    @Test
    public void test() throws IOException {
        File file = new File("C:\\Users\\Kangshitao\\Desktop\\io\\hello.txt");
        //1.创建一个与file同目录下的另一个文件，文件名为h1.txt
        File f2 = new File(file.getParent(),"h1.txt");
        if(f2.createNewFile()){
            System.out.println("success!");
        };
        //2.输出所有后缀名为".jpg"的文件名
        File f3 = new File(file.getParent());
        String[] fileName = f3.list();
        for(String n : fileName){
            if(n.endsWith(".jpg")){
                System.out.println(n);
            }
        }
    }
}
