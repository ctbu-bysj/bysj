package com.ctbu.schoolofai.btsjmanager.openingReport.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;

public interface OpingReportService {
    /**
     * 保存开题报告
     * @param opeingReport
     * @return
     */
     String save(OpeingReport opeingReport);

    OpeingReport  findByStudentId(long id);

    /**
     * 通过学生查找
     * @param student
     * @return
     */
    OpeingReport  findByStudent(Student student);
}
