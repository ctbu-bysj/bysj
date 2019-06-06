package com.ctbu.schoolofai.btsjmanager.student.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentDao extends JpaRepository<Student,Long> {
    /**
     * 通过选题查找
     * @param topic
     * @return
     */
  List<Student> findByTopic(Topic topic);

    /**
     * 通过是否确认选题状态查找学生
     * @param state
     * @return
     */
  List<Student> findByDeterminesStatus(String state);
}
