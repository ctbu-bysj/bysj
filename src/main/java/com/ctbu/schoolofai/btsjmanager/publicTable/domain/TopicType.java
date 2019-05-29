package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 题目类型表
 */
@Data
@Entity(name = "topicType")
public class TopicType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    /**
     * 题目类型名字
     */
    private  String topicTypeName;
}
