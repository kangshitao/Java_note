package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Kangshitao
 * @date 2021年4月13日 下午2:48
 */
public class OIOS_Exer {
    @Test
    public void outputTest(){

        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("object1.dat"));
            oos.writeObject(new String("hello"));
            oos.flush();
            oos.writeObject(new Person("kang",13));
            oos.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(oos!=null){
                try{
                    oos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void OIS(){
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream("object1.dat"));
            Object a = ois.readObject();
            System.out.println((String) a);
            System.out.println((Person) ois.readObject());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
