package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 教师出的题目表
 */
@Data
public class TopicDo {

    /**
     * id,自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id",length = 50)
    private String id;

    /**
     * 题目名称
     */
    @Column(name = "topic_name")
    private String topicName;

    /**
     * 题目类型
     */
    @Column(name = "topic_select")
    private String topicType;

    /**
     * 出题教师姓名，教师提交时系统自动添加
     */
    @Transient //表示这个属性只是路过，忽略他，这个字段不是该表的，是其他表的
    private String teacherName;

    /**
     * 审核状态,0表示未审核，1表示已审核
     */
    @Column(name = "audit_state")
    private Short State;

    /**
     * 审核意见
     */
    private String auditOpinion;

}
