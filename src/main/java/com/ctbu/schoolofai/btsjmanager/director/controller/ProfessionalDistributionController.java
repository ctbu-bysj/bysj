package com.ctbu.schoolofai.btsjmanager.director.controller;

import com.ctbu.schoolofai.btsjmanager.director.service.ProfessionalDistributionService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.ProfessionalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProfessionalDistributionController {

    @Autowired
    ProfessionalDistributionService professionalDistributionService;

    public String list(Model model){

        List<ProfessionalDistribution> professionalDistributions=professionalDistributionService.findAll();

        model.addAttribute("data",professionalDistributions);

        return ""; //这里是出题任务分配页面的位置
    }
}
