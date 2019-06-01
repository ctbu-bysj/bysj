package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 软件开发技术表
 */
@Data
@Entity(name = "softwareTechnology")
public class SoftwareTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long id;
    /**
     * 技术名字
     */
    private  String  SoftTechName;



}
