package atguigu.abstractExe3;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午9:45
 */
public class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(){}

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }
    public String toString(){
        return this.getClass()+"["+super.toString()+"]";
    }
}
