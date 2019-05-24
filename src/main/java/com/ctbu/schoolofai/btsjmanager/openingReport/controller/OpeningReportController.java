package com.ctbu.schoolofai.btsjmanager.openingReport.controller;

import com.ctbu.schoolofai.btsjmanager.openingReport.domain.OpeingReport;
import com.ctbu.schoolofai.btsjmanager.openingReport.service.OpingReportService;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OpeningReportController {

    @Source
   private OpingReportService opingReportService;

    @RequestMapping("/saveOpen")
    public  String saveOpen(OpeingReport opeingReport){

        opingReportService.save(opeingReport);
        return "";
    }

}
