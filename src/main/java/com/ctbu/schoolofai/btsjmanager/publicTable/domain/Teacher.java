package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 教师表（教师基本信息）
 */
@Data
@Entity
@Table(name = "teacher")
public class Teacher
{
    /**
     * 教师ID
     */
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private long  id;

    /**
     * 教师登录名（工号）
     */
    @Column(name = "login_name" ,length = 20,unique = true)
    private String loginName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "true_name",length = 20)
    private String trueName;

    /**
     * 身份（职位）
     */
    @Column(name = "identity",length = 20)
    private String Identity	;

    /**
     * 登录次数
     */
    @Column(name = "login_times" )
    private  Long  loginTimes;

    /**
     * 性别
     */
    @Column(name = "sex",length = 1)
    private String   sex;

    /**
     * 科目
     */
    @Column(name = "subject",length = 20)
    private String subject;

    /**
     * 电话号码
     */
    @Column(name = "tel",length = 11)
    private String tel;

    /**
     * qq号码
     */
    @Column(name = "qq",length = 20)
    private String qq;

    /**
     * 教师所属小组
     */
    @ManyToOne
    @JoinColumn(name = "group_id")
    private  Group group;

    /**
     * 教师在小组中的身份
     */
    private  String  groupIdentity;

    /**
     * 外键，获取教师需要出题的数量
     */
    @OneToOne
    @JoinColumn(name = "professionalDistribution_id")
    private  ProfessionalDistribution professionalDistribution;
    /**
     * 系统身份
     */
    private  String systemStatus;
    /**
     * 角色
     */
    @ManyToMany(cascade=CascadeType.REFRESH)
    @JoinTable(name="teacher_role",inverseJoinColumns=@JoinColumn(name="role_id"),
            joinColumns=@JoinColumn(name="teacher_id"))
    private Set<Role> roles=new HashSet<Role>();
}