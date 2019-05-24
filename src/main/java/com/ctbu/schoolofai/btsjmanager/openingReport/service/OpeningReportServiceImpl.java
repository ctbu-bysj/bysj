package com.ctbu.schoolofai.btsjmanager.openingReport.service;

import com.ctbu.schoolofai.btsjmanager.openingReport.dao.OpeningReportDao;
import com.ctbu.schoolofai.btsjmanager.openingReport.domain.OpeingReport;
import org.springframework.beans.factory.annotation.Autowired;

public class OpeningReportServiceImpl implements OpingReportService {
   @Autowired
   private  OpeningReportDao openingReportDao;

    @Override
    public String save(OpeingReport opeingReport) {

          OpeingReport opeing= openingReportDao.save(opeingReport);

          if(opeing.getOpeningId()!=null)
              return "succsse";
          else return null;

    }
}
