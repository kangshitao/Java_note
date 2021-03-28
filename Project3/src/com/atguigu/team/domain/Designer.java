package com.atguigu.team.domain;

/**
 * @author Kangshitao
 * @date 2021年3月28日 上午11:45
 */
public class Designer extends Programmer{
    private double bonus;
    public Designer(){}
    public Designer(double bonus){
        this.bonus = bonus;
    }
    public Designer(int id,String name,int age, double salary, Equipment equipment,double bonus){
        super(id,name,age,salary,equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String showInfo(){
        return getMemberId()+"/"+getDetails()+"\t"+"设计师"+"\t"+bonus;
    }
    public String toString(){
        return getDetails()+"\t"+"设计师"+"\t"+getStatus()+"\t"+
                bonus+"\t"+"\t\t"+getEquipment().getDescription();
    }
}
