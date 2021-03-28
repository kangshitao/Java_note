package com.atguigu.team.domain;

/**
 * @author Kangshitao
 * @date 2021年3月28日 上午11:46
 */
public class PC implements Equipment {
    private String model;  //机器型号
    private String display; //显示器名称

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDescription() {
        return model + "(" + display + ")";
    }
}
