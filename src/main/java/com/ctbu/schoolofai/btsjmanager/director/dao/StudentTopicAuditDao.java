package com.ctbu.schoolofai.btsjmanager.director.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 审核学生选题情况以及教师确认情况
 */
public interface StudentTopicAuditDao extends JpaRepository<Student,String> {

    @Query(value = "select * from student where state='1'",nativeQuery = true)//书写查询语句
    public List<Student> findByState(Short state);
}
