package com.ctbu.schoolofai.btsjmanager.stunent.controller;

import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.graduationTopic.service.TopicService;
import com.ctbu.schoolofai.btsjmanager.stunent.domain.Student;
import com.ctbu.schoolofai.btsjmanager.stunent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TopicService topicService;


    @RequestMapping("/selectTopic")
    public  String selectTopic(@PathVariable("id") Long id, Model model){

       Topic topic= topicService.findTopicById(id);
        topic.setState("true");
        topicService.update(topic);

        HttpSession session;
        Student student =session.getAttribute("");

        return "";

    }

}
