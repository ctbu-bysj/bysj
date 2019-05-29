package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 软件开发技术表
 */
@Data
@Entity(name = "softwareTechnology")
public class SoftwareTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    /**
     * 技术名字
     */
    private  String  SoftTechName;



}
