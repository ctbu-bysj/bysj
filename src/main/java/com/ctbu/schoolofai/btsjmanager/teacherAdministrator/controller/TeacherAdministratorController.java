package com.ctbu.schoolofai.btsjmanager.teacherAdministrator.controller;

import com.ctbu.schoolofai.btsjmanager.basicInformation.service.BasicInformationService;
import com.ctbu.schoolofai.btsjmanager.collegeProgress.service.CollegeProgressService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.BasicInformation;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.CollegeProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherAdministratorController {

    @Autowired
    private CollegeProgressService collegeProgressService;
    @Autowired
    private BasicInformationService basicInformationService;

    /**
     * 保存毕业设计工作基本信息
     * @param basicInformation
     * @return
     */
 @RequestMapping("/saveBasicIn")
    public  String saveBasicIn(BasicInformation basicInformation){
              basicInformation.setCollegePro(false);
             basicInformationService.saveBasicIn(basicInformation);
             return "";

 }

    /**
     * 保存工作阶段信息
     * @param collegeProgress
     * @param model
     * @return
     */
    @RequestMapping("/saveCollegeProgress")
    public  String saveCollegeProgress(@RequestBody List<CollegeProgress>  collegeProgress, Model model){
            BasicInformation basicInformation=basicInformationService.findByCollege(false);
        for (CollegeProgress college:collegeProgress) {
             college.setBasicInformation(basicInformation);
        } 
            collegeProgressService.saveColllegePre(collegeProgress);
           return "";
    }

}
