package com.ctbu.schoolofai.btsjmanager.publicTable.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 课题表
 */
@Data
@Entity
@Table(name = "topic")
public class Topic
{

    /**
     * 课题id    主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    /**
     * 题目
     */
    @Column(name = "topic")
    private String topic;

    /**
     * 题目细节
     */
    private String detailed	;

    /**
     * 出题教师 (教师登录名/工号)
     */
    private String creator;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date creatorDate;

    /**
     * 选择状态
     */
    @Column(name = "topic_status")
    private String  topicStatus	;

    /**
     * 总名额
     */
    @Column(name = "topic_quota")
    private short  topicQuota;

    /**
     * 剩余名额
     */
    @Column(name = "remaining_quota")
    private short remainingQuota;

    /**
     * 审核意见
     */
    @Column(name = "audit_opinion")
    private String auditOpinion;

    /**
     * 审核状态
     */
    @Column(name = "approval_status")
    private String  approvalStatus;

    /**
     * 届数
     */
    @Column(name = "period")
    private  String period;
    /**
     * 题目类型
     */
    private  String topicType;
    /**
     * 选题专业
     */
    private  String choiceProfessional;

    /**
     * 科研相关项目
     */
    private  String scientificResearch;

    /**
     * 选题模式
     */
    private  String model;

    /**
     * 技术路线
     */
    private  String technicalRoute;
    /**
     * 预期成果
     */
    private  String expected;

    /**
     * 题目提交状态   1.未提交  2.已提交
     */
    private  String state;

}