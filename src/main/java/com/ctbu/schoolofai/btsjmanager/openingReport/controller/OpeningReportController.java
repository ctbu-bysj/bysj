package com.ctbu.schoolofai.btsjmanager.openingReport.controller;


import com.ctbu.schoolofai.btsjmanager.openingReport.service.OpingReportService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.stunent.service.StudentService;
import org.hibernate.annotations.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OpeningReportController {

    @Source
   private OpingReportService opingReportService;

    @Autowired
    private StudentService studentService;

    /**
     * 保存开题报告
     * @param opeingReport
     * @return
     */
    @RequestMapping("/saveOpen")
    public  String saveOpen(OpeingReport opeingReport){

        opingReportService.save(opeingReport);
        return "";
    }

    /**
     * 我的开题报告
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/myOpen/{id}")
    public  String myOpen(@PathVariable("id")String id, Model model){

       OpeingReport opeingReport= opingReportService.findByStudentId(id);
       Student student=studentService.findById(id);
       model.addAttribute("opeingReport",opeingReport);
       model.addAttribute("stuent",student);

        return "";
    }

}
