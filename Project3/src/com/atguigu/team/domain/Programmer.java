package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

/**
 * @author Kangshitao
 * @date 2021年3月28日 上午11:45
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() { }

    public Programmer(Equipment equipment){
        this.equipment = equipment;
    }
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberid(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String showInfo(){
        return memberId+"/"+getDetails()+"\t"+"程序员";
    }

    @Override
    public String toString(){
        return getDetails()+"\t"+"程序员"+"\t"+status+"\t\t\t\t\t"+equipment.getDescription();
    }
}
