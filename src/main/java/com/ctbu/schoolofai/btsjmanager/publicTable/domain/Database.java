package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 数据库开发技术表
 */
@Data
@Entity(name = "Database")
public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long id;
    /**
     * 数据库名字
     */
    private  String databaseName;
}
