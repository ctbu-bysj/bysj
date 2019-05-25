package com.ctbu.schoolofai.btsjmanager.basicInformation.controller;

import com.ctbu.schoolofai.btsjmanager.basicInformation.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.graduationTopic.service.TopicService;
import com.ctbu.schoolofai.btsjmanager.stunent.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TopicService topicService;


    @RequestMapping("/selectTopic/{id}")
    public  String selectTopic(@PathVariable("id") Long id, Model model, HttpServletRequest request){

       Topic topic= topicService.findTopicById(id);
        topic.setState("true");
        topicService.update(topic);


        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        student.setTopic(topic);
        studentService.update(student);
        return "";

    }

}
