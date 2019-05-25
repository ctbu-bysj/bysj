package com.ctbu.schoolofai.btsjmanager.grade.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Grade;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GradeDao extends JpaRepository<Grade,String> {



}
