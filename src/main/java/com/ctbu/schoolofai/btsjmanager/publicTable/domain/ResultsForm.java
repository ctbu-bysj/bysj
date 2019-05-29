package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 成果形式表
 */
@Data
@Entity(name = "resultsForm")
public class ResultsForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    /**
     * 题目类型名字
     */
    private  String resultsFormName;
}
