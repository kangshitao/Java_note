package com.atguigu.team.service;

import com.atguigu.team.domain.*;
import static com.atguigu.team.service.Data.*;
/**
 * @author Kangshitao
 * @date 2021年3月28日 下午3:54
 */
public class NameListService {
    private Employee[] employees;
    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for(int i = 0; i<employees.length; i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            switch(type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index){
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        Equipment equipment;
        switch (type){
            case PC:
                equipment = new PC(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
                return equipment;
            case NOTEBOOK:
                equipment = new NoteBook(EQUIPMENTS[index][1],Double.parseDouble(EQUIPMENTS[index][2]));
                return equipment;
            case PRINTER:
                equipment = new Printer(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
                return equipment;
        }
        return null;
    }

    public Employee[] getALLEmployees(){
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException{
        for(Employee e: employees){
            if(e.getId() == id){
                return e;
            }
        }
        //如果没有此员工，则手动生成异常类对象并抛出
        throw new TeamException("找不到指定的员工");
    }
}
