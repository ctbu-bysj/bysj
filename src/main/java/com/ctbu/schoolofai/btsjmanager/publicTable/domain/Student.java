package com.ctbu.schoolofai.btsjmanager.publicTable.domain;


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
     private  String studentId;
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
      * 专业
      */
     private String major;

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
      * 一次答辩学生所属小组
      */
     @ManyToOne
     @JoinColumn(name = "group_id")
     private  Group group;

     /**
      * 二次答辩学生所属小组
      */
     @ManyToOne
     @JoinColumn(name = "secondGroup_id")
     private  SecondPleaGroup secondPleaGroup;

     /**
      * 学生成绩
      */
     @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
     @JoinColumn(name = "grade_id", referencedColumnName = "gradeId")//people中的address_id字段参考address表中的id字段
     private Grade grade;//地址
     /**
      * 初稿
      */
     @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
     @JoinColumn(name = "firstDraft_id", referencedColumnName = "firstDraftId")//people中的address_id字段参考address表中的id字段
     private FirstDraft firstDraft;//
     /**
      * 中期检查
      */
     @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
     @JoinColumn(name = "midCheck_id", referencedColumnName = " midCheckId")//people中的address_id字段参考address表中的id字段
     private MidCheck midCheck;//地址

     /**
      * 一次答辩定稿
      */
     @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
     @JoinColumn(name = "paperFinalize_id", referencedColumnName = "paperFinalizeId")//people中的address_id字段参考address表中的id字段
     private PaperFinalize paperFinalize;//地址

     /**
      * 二次答辩定稿
      */
     @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
     @JoinColumn(name = "secondPaperFinalize_id", referencedColumnName = "secondPaperFinalizeId")//people中的address_id字段参考address表中的id字段
     private SecondPaperFinalize secondPaperFinalize;//地址
}
