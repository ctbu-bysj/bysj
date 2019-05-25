package com.ctbu.schoolofai.btsjmanager.openingReport.dao;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningReportDao extends JpaRepository<OpeingReport,String> {

    OpeingReport findOpeingReportByStudent(String id);
}
