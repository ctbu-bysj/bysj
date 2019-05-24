package com.ctbu.schoolofai.btsjmanager.publicTable.domain;


import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "student")
public class Student {
     /**
      * id
      */
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
     private  long studentId;
     /**
      * 登录名
      */
     private  String loginName;
     /**
      * 学生姓名
      */
     private  String studnetName;
     /**
      * 密码
      */
     private  String loginPwd;
     /**
      * 性别
      */
     private  String gender;
     /**
      * 班级
      */
     private  String  Classes;
     /**
      * 选题
      */
     @ManyToOne
     @JoinColumn(name = "topic_topic_id")
     private Topic topic;

     /**
      * 登录次数
      */
     private String loginTimes;
     /**
      * 电话
      */
     private  String tel;
     /**
      * qq
      */
     private  String qq;
     /**
      * 届数
      */
     private  String period;
     /**
      * 学生所属小组
      */
     @ManyToOne
     @JoinColumn(name = "group_id")
     private  Group group;

     @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
     @JoinColumn(name = "grade_id", referencedColumnName = "gradeId")//people中的address_id字段参考address表中的id字段
     private Grade grade;//地址



}
