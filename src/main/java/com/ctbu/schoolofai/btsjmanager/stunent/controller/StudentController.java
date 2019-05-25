package com.ctbu.schoolofai.btsjmanager.stunent.controller;

import com.ctbu.schoolofai.btsjmanager.firstDraft.service.FirstDraftService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.FirstDraft;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.stunent.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.topic.service.TopicService;
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
    @Autowired
    private FirstDraftService firstDraftService;

    /**
     * 学生选题
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/selectTopic/{id}")
    public  String selectTopic(@PathVariable("id") String id, Model model, HttpServletRequest request){

       Topic topic= topicService.findTopicById(id);
        topic.setState("true");
        topicService.update(topic);


        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        student.setTopic(topic);
        studentService.update(student);
        return "";

    }

    /**
     * 初稿提交
     * @param firstDraft
     * @param request
     * @return
     */
    @RequestMapping("/firstDraftSave")
    public String FirstDraft(FirstDraft firstDraft,HttpServletRequest request){

       FirstDraft firstDraftNew= firstDraftService.save(firstDraft);
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");

        student.setFirstDraft(firstDraftNew);
        studentService.update(student);
        return "";
    }

}
