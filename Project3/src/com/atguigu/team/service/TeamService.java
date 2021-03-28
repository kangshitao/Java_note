package com.atguigu.team.service;

import com.atguigu.team.domain.*;

/**
 * @author Kangshitao
 * @date 2021年3月28日 下午4:43
 */
public class TeamService {
    private static int  counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    /**
     * 返回当前开发团队的所有对象
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] programmers = new Programmer[total];
        for(int i=0; i < total; i++){
            programmers[i] = team[i];
        }
        return programmers;
    }

    /**
     * 将成员e添加到开发团队中
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException{
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer p = (Programmer) e;
        if(isExist(p)){
            throw new TeamException("该员工已在本开发团队中");
        }
        if(p.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("该员工已是某团队成员");
        }else if (p.getStatus().getNAME().equals("VOCATION")){
            throw new TeamException("该员正在休假，无法添加");
        }
        int numArchitect = 0, numDesigner = 0, numProgramer = 0;
        for(int i = 0; i<total; i++){ //统计各职业人员的个数，注意顺序
            if(team[i] instanceof Architect){
                numArchitect++;
            }else if(team[i] instanceof Designer){
                numDesigner++;
            }else {
                numProgramer++;
            }
        }
        if(p instanceof Architect){ //注意这里判断个数的语句一定要写在里面，保证外层if能够进去。
            if(numArchitect>=1) throw new TeamException("团队中至多只能有一名架构师");
        }else if(p instanceof Designer){
            if(numDesigner>=2) throw new TeamException("团队中至多只能有两名设计师");
        }else if(p instanceof Programmer){
            if(numProgramer>=3) throw new TeamException("团队中至多只能有三名程序员");
        }
        //将开发人员加入到开发团队
        team[total++] = p;
        p.setMemberid(counter++);
        p.setStatus(Status.BUSY);
    }

    /**
     * 判断e是否已经在开发团队中
     * @param p
     * @return
     */
    private boolean isExist(Programmer p){
        for(int i = 0; i<total; i++){
            if(team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * 从开发团队中功能删除指定memberId的成员
     * @param memberId
     * @throws TeamException
     */
    public void removeMember(int memberId) throws TeamException{
        int i = 0;
        for(; i<total;i++){
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i==total) throw new TeamException("找不到指定memberId的员工，删除失败");
        //如果找到员工，则将其从team中移除
        for(int j = i;j<total-1;j++){
            team[j] = team[j+1];
        }
        team[--total] = null;
    }
}
