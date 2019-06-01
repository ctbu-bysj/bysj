package com.ctbu.schoolofai.btsjmanager.collegeProgress.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.CollegeProgress;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CollegeProgressDao extends JpaRepository<CollegeProgress,Long> {


}
