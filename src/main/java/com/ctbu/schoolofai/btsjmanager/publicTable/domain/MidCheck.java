package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 中期检查表
 */
@Data
@Entity
@Table(name = "midCheck")

public class MidCheck {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long midCheckId;
    /**
     * t题目名字
     */
    private String topicName;
    /**
     * 学生姓名
     */
    private  String  studentName;
    /**
     * 项目进度
     */
    private  String   projectSchedule;
    /**
     * 论文进度
     */
    private  String   paperSchedule;
    /**
     * 检查意见
     */
    private  String   CheckOpinion;
    /**
     * 中期检查提交论文地址
     */
    private  String   paperPath;
    /**
     * 中期检查代码地址
     */
   private  String   codePath;
}
