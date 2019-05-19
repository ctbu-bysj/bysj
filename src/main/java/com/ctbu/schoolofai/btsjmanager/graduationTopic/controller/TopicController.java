package com.ctbu.schoolofai.btsjmanager.graduationTopic.controller;

import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.graduationTopic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topicList")
    public  String  list(Model model){
        List<Topic> topics=topicService.findTopicByState("1");
        model.addAttribute("topics",topics);
        return  "";

    }
}
