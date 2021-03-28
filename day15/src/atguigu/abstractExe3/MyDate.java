package atguigu.abstractExe3;

/**
 * @author Kangshitao
 * @date 2021年3月22日 下午9:45
 */
public class MyDate {
    private int year;
    private int mouth;
    private int day;

    public MyDate(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public String toDateString(){
        return year+"年"+mouth+"月"+day+"日";
    }
}
