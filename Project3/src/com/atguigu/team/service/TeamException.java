package com.atguigu.team.service;

/**
 * @author Kangshitao
 * @date 2021年3月28日 下午4:36
 */
public class TeamException extends RuntimeException{
    static final long serialVersionUID = -1234554677853939L;
    public TeamException(){}
    public TeamException(String msg){
        super(msg);
    }
}
