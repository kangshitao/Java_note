package com.atguigu.team.service;

/**
 * @author Kangshitao
 * @date 2021年3月28日 下午3:34
 */
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");
    public String getNAME(){
        return NAME;
    }
    public String toString(){
        return NAME;
    }
}
