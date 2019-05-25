package com.ctbu.schoolofai.btsjmanager.openingReport.service;

import com.ctbu.schoolofai.btsjmanager.openingReport.dao.OpeningReportDao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;
import com.ctbu.schoolofai.btsjmanager.stunent.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;

public class OpeningReportServiceImpl implements OpingReportService {
   @Autowired
   private  OpeningReportDao openingReportDao;
   @Autowired
   private StudentDao studentDao;

    @Override
    public String save(OpeingReport opeingReport) {

          OpeingReport opeing= openingReportDao.save(opeingReport);

          if(opeing.getOpeningId()!=null)
              return "succsse";
          else return null;

    }

    @Override
    public OpeingReport findByStudentId(String id) {
        return openingReportDao.findOpeingReportByStudent(id);
    }
}
