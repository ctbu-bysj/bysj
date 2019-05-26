package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 二次答辩小组
 */
@Data
@Entity
@Table(name = "group")
public class SecondPleaGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String groupId;
    /**
     * 小组名
     */
    private  String groupName;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private  Date endTime;
    /**
     * 答辩地点
     */
    private  String address;

    /**
     * 小组中的学生
     */
    @OneToMany(mappedBy = "secondPleaGroup")
    private Set<Student> students=new HashSet<Student>();

    /**
     * 小组中的老师
     */
    @OneToMany(mappedBy = "secondPleaGroup")
    private Set<Teacher> teachers=new HashSet<Teacher>();
}
