package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 学生选题表
 */
@Data
public class StudentTopicDo {

    /**
     * id,主键,自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 50)
    private String id;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 题目名称
     */
    private String topicName;

    /**
     * 出题教师姓名
     */
    private String teacherName;

    /**
     * 审核状态（教师确定状态以及负责人确定状态），教师确定+1，负责人审核后再+1
     */
    private Short State;
}
