package com.ctbu.schoolofai.btsjmanager.teacher.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,String>
{
    /**
     * 查询所有选择指定题目的所有的学生
     * @param topic_id
     * @return
     */
     List<Student> findByTopic_Id(String topic_id);


    /**
     * 教师确定学生选题状态
     * @param sta
     * @param id
     * @return
     */
     @Query(value = "update student  set teacher_determines_status = :sta where id = :id" ,nativeQuery = true)
     @Modifying
     int updateTeacherDeterminesStatus(@Param("sta") String sta,@Param("id") String id);

    /**
     * 查询学生选题情况
     * @param id
     * @return
     */
     Student findByStudentId(String id);
}
