package com.ctbu.schoolofai.btsjmanager.director.controller;

import com.ctbu.schoolofai.btsjmanager.director.service.TopicAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class TopicAuditController {

    @Autowired
    TopicAuditService topicAuditService;

    public String list(Model model){

        //通过id查找需要审核的题目
        TopicDo topicDos=topicAuditService.findById(id);

        model.addAttribute("data",topicDos);

        return ""; //这里是审核题目信息页面的位置
    }
}
