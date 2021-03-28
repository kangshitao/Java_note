package atguigu.abstractExe3;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午9:45
 */
public class HourlyEmployee extends Employee{
    private double wage;
    private double hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage*hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
    public String toString(){
        return this.getClass()+"["+super.toString()+"]";
    }
}
