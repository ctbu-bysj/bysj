package com.ctbu.schoolofai.btsjmanager.director.controller;

import com.ctbu.schoolofai.btsjmanager.director.service.StudentTopicAuditService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentTopicAuditCotroller {

    @Autowired
    StudentTopicAuditService studentTopicAuditService;

    public String list(Model model,String id){

        //返回所有需要审核的选题信息
        List<Student> studentTopicDos = studentTopicAuditService.findAll();

        model.addAttribute("data",studentTopicDos);

        return ""; //这里是审核题目信息页面的位置
    }
}
