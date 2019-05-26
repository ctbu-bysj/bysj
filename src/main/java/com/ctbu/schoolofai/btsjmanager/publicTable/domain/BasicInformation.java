package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 毕业设计工作表
 */
@Data
@Entity
@Table(name = "basicIn")
public class BasicInformation {

    /**
     * 主键  阶段id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  String  id;
    /**
     * 毕业生年份
     */
  private String year;
    /**
     * 教学管理人员
     */
    private String teachingAdministrator ;
    /**
     * 论文查重标准
     */
    private String paperCheckCriteria;
    /**
     * 论文查重修改标准
     */
    private String paperReviewStandards;
    /**
     * 毕业设计工作阶段是否创建
     */
    private boolean collegePro;

    /**
     * 小组中的学生
     */
    @OneToMany(mappedBy = "basicInformation")
    private Set<CollegeProgress> students=new HashSet<CollegeProgress>();

}
