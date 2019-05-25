package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "openingReport")
public class OpeingReport
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long  openingId;
    private  String  topicBasis;//立题依据
    private  String  researchContent;//研究主要内容
    private  String  DevelopmentTechnology;//开发技术
    private  String  DatabaseTechnology;//数据库技术
    private  String  ResearchMethodsAndExperimentalConditions;//研究方法与实验条件
    private  String  ProjectPlanningAndScheduling;//项目计划与进度安排
    private  String  MajorReferences;//主要参考文献

}
