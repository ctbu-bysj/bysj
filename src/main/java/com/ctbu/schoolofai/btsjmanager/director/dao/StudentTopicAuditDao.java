package com.ctbu.schoolofai.btsjmanager.director.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 审核学生选题情况以及教师确认情况
 */
public interface StudentTopicAuditDao extends JpaRepository<StudentTopicDo,String> {
}
