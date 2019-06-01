package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 成果形式表
 */
@Data
@Entity(name = "resultsForm")
public class ResultsForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long id;
    /**
     * 题目类型名字
     */
    private  String resultsFormName;
}
