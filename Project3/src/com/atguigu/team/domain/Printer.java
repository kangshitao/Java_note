package com.atguigu.team.domain;

/**
 * @author Kangshitao
 * @date 2021年3月28日 上午11:46
 */
public class Printer implements Equipment {
    private String name;
    private String type;

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return name + "(" + type + ")";
    }
}
