package com.ctbu.schoolofai.btsjmanager.stunent.domain;


import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity(name = "student")
public class Student {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
     private  long studentId;
     private  String loginName;
     private  String studnetName;
     private  String loginPwd;
     private  String gender;
     private  String  Classes;
     @ManyToOne
     @JoinColumn(name = "topic_topic_id")
     private Topic topic;

}
