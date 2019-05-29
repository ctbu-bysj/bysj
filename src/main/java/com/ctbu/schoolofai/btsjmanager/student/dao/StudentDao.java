package com.ctbu.schoolofai.btsjmanager.student.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentDao extends JpaRepository<Student,String> {
    /**
     * 通过选题查找
     * @param topic
     * @return
     */
  List<Student> findByTopic(Topic topic);

}
