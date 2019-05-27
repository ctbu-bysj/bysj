package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 学院出题分配表
 */
@Data
@Entity
@Table(name = "distributionCollege")
public class DistributionCollege {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private String  id;
    /**
     * 所属学科
     */
    private String  discipline;
    /**
     * 学科负责人
     */
    private String  disciplineHead;
    /**
     * 学科教师总量
     */
    private String  teacherTotal;
    /**
     * 已分配题目数量
     */
    private String  allocatedQuantity;
    /**
     * 已出题目数量
     */
    private String  topicQuantity;

    /**
     * 毕业生数量
     */
    private String  numberGraduates;
}
