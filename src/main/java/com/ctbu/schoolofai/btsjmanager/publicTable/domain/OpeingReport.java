package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "openingReport")
public class OpeingReport
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" ,length = 20)
    private  long openingId;
    private  String  topicBasis;//立题依据
    private  String  researchContent;//研究主要内容
    private  String  DevelopmentTechnology;//开发技术
    private  String  DatabaseTechnology;//数据库技术
    private  String  ResearchMethodsAndExperimentalConditions;//研究方法与实验条件
    private  String  ProjectPlanningAndScheduling;//项目计划与进度安排
    private  String  MajorReferences;//主要参考文献
    /**
     * 检查意见
     */
    private  String  opinion;
    /**
     * 学生id
     */
    @OneToOne(fetch = FetchType.EAGER)
    private Student student;


}
