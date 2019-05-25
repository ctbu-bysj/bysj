package com.ctbu.schoolofai.btsjmanager.basicInformation.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;


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


}
