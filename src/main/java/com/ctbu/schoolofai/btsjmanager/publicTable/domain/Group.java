package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "group")
public class Group {
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
     * 小组中的学生
     */
    @OneToMany(mappedBy = "group")
    private Set<Student> students=new HashSet<Student>();

    /**
     * 小组中的老师
     */
    @OneToMany(mappedBy = "group")
    private Set<Teacher> teachers=new HashSet<Teacher>();
}
