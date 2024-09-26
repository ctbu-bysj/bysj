package com.ctbu.schoolofai.btsjmanager.instructor.domain;

import lombok.Data;

import javax.persistence.*;

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
    private String  id;

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

}
