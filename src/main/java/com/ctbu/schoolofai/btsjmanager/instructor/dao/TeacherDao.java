package com.ctbu.schoolofai.btsjmanager.instructor.dao;

import com.ctbu.schoolofai.btsjmanager.instructor.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher,String>
{
    /**
     * 根据教师登录名（工号）查询该老师所有的信息
     * @param loginName
     * @return
     */
    public Teacher findByLoginName(String loginName);


}
