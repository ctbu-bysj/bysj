package com.ctbu.schoolofai.btsjmanager.student.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;

import java.util.List;


public interface StudentService {
    /**
     * 学生选题更新学生表
     * @param student
     * @return
     */
    String update(Student student);

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    Student findById(String id);

    /**
     * 通过选题查找
     * @param topic
     * @return
     */
    List<Student>  findByTopic(Topic topic);

    /**
     * 查找所有
     * @return
     */
    List<Student>  findAll();

    /**
     * 保存
     * @param student
     * @return
     */
    Student save(Student student);


}
