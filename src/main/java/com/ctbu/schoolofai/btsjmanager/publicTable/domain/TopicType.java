package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 题目类型表
 */
@Data
@Entity(name = "topicType")
public class TopicType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long id;
    /**
     * 题目类型名字
     */
    private  String topicTypeName;
}
