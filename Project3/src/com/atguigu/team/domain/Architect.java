package com.atguigu.team.domain;

/**
 * @author Kangshitao
 * @date 2021年3月28日 上午11:46
 */
public class Architect extends Designer{
    public int stock;
    public Architect(int stock){
        this.stock = stock;
    }
    public Architect(int id, String name, int age, double salary,
                     Equipment equipment, double bonus,int stock){
        super(id,name,age,salary,equipment,bonus);
        this.stock = stock;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public String showInfo(){
        return getMemberId()+"/"+getDetails()+"\t"+"架构师"+"\t"+getBonus()+"\t"+stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t"+"架构师"+"\t"+getStatus()+"\t"+
                getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
    }
}
