package com.ctbu.schoolofai.btsjmanager.openingReport.dao;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningReportDao extends JpaRepository<OpeingReport,String> {

    OpeingReport findOpeingReportByStudent(String id);

    /**
     * 通过学生查找
     * @param student
     * @return
     */
    OpeingReport findByStudent(Student student);
}
