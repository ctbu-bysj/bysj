package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 专业负责人分配题目
 */
@Data
@Entity
@Table(name = "professional_distribution")
public class ProfessionalDistribution {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private String  id;

    /**
     * 教师id，从教师表调取信息
     */
    private String teacherId;

    /**
     * 分配数量
     */
    private String number;

    /**
     * 可分配的题目数量
     */
    private String getNumber;
}
