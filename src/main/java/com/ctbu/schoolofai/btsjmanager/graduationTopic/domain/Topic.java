package com.ctbu.schoolofai.btsjmanager.graduationTopic.domain;

import com.ctbu.schoolofai.btsjmanager.stunent.domain.Student;
import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long topicId;
    private  String topicName;
    private  int  topicPlaces;
    private  String topicType;
    private  String  topicTeacher;
    private  String  disciplineOfTeacher;
    private  String  state;

    @OneToMany(mappedBy = "topic")
    private Set<Student> students=new HashSet<Student>();

}
