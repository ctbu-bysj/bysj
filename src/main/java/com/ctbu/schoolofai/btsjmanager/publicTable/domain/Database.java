package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 数据库开发技术表
 */
@Data
@Entity(name = "Database")
public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String id;
    /**
     * 数据库名字
     */
    private  String databaseName;
}
