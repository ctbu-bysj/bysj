package com.ctbu.schoolofai.btsjmanager.distributionCollege.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentDao extends JpaRepository<Student,String> {

//    @Query(value = "update Studnet set name=?1 where id=?2 ", nativeQuery = true)
//    @Modifying
//    public void updateOne(String name,int id);

}
