package com.atguigu.exe;

import java.io.File;

/**
 * @author Kangshitao
 * @date 2021年4月9日 下午4:14
 */
public class FileExe2 {

    public static void main(String[] args) {
        File root = new File("C:\\Users\\Kangshitao\\Desktop\\io");
        FileExe2 test = new FileExe2();

        test.showAll(root);
        test.deleteFile(root);
    }

    //删除指定目录下所有文件，包括子目录
    public void deleteFile(File path){
        //path是目录
        File[] names = path.listFiles();
        for(File f: names){
            // 如果file是文件，直接delete
            // 如果file是目录，先把它的下一级干掉，然后删除自己
            if(f.isDirectory()){
                deleteFile(f);
            }
            f.delete();
        }
    }

    //列出指定目录下所有文件，包括子目录文件
    public void showAll(File path){
        File[] names = path.listFiles();
        for(File f: names){
            if(f.isDirectory()){
                showAll(f);
            }else{
                System.out.println(f.getAbsoluteFile());
            }
        }
    }
}