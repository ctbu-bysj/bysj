package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 成绩表
 */
@Data
@Entity
@Table(name = "grade")
public class Grade {
    /**
     * 成绩ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private String  gradeId;

    /**
     * 开题报告成绩
     */
    private String openRportGrade;
    /**
     * 开题报告意见
     */
    private  String openRportOpinion;

    /**
     * 中期报告成绩
     */
    private String midGrade;
    /**
     * 中期报告意见
     */
    private  String midOpinion;

    /**
     * 初稿成绩
     */
    private String firstDraftGrade;
    /**
     * 初稿意见
     */
    private  String firstDraftOpinion;


    /**
     * 一次答辩定稿成绩
     */
    private String paperFinalizeGrade;
    /**
     * 一次答辩定稿意见
     */
    private  String paperFinalizeOpinion;

    /**
     * 二次答辩定稿成绩
     */
    private String secindPaperFinalizeGrade;
    /**
     * 二次答辩定稿意见
     */
    private  String secondPaperFinalizeOpinion;

    /**
     * 一次答辩成绩
     */
    private String  firstReplyGrade;
    /**
     * 一次答辩意见
     */
    private  String  firstReplyOpinion;

    /**
     * 二次答辩成绩
     */
    private String  secondReplyGrade;
    /**
     * 二次答辩意见
     */
    private  String  secondReplyOpinion;

    /**
     * 最终答辩成绩
     */
    private String  finalReplyGrade;
    /**
     * 最终答辩意见
     */
    private  String  finalReplyOpinion;
    /**
     * 查重率
     */
    private  String  recheckRate;
    /**
     * 论文格式
     */
     private  String paperFormat;

}
