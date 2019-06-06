package com.ctbu.schoolofai.btsjmanager.director.controller;

import com.ctbu.schoolofai.btsjmanager.director.service.TopicAuditService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 题目审核页面控制
 */
@Controller
public class TopicAuditController {

    @Autowired
    TopicAuditService topicAuditService;

    @RequestMapping("director/index")
    public String list(Model model){

        //返回所以的出题信息
        List<Topic> topicDos=topicAuditService.findAll();

        model.addAttribute("data",topicDos);

        return "director/index"; //这里是审核题目信息页面的位置
    }
}
