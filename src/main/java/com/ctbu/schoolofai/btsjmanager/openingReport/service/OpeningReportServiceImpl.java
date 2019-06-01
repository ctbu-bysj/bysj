package com.ctbu.schoolofai.btsjmanager.openingReport.service;

import com.ctbu.schoolofai.btsjmanager.openingReport.dao.OpeningReportDao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.student.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

import static java.sql.Types.NULL;


public class OpeningReportServiceImpl implements OpingReportService {
   @Autowired
   private  OpeningReportDao openingReportDao;
   @Autowired
   private StudentDao studentDao;

    @Override
    public String save(OpeingReport opeingReport) {

          OpeingReport opeing= openingReportDao.save(opeingReport);

          if(opeing.getOpeningId()!=NULL)
              return "succsse";
          else return null;

    }

    @Override
    public OpeingReport findByStudentId(long id) {
        return openingReportDao.findOpeingReportByStudent(id);
    }

    @Override
    public OpeingReport findByStudent(Student student) {
        return null;
    }
}
