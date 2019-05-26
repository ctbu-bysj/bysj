package com.ctbu.schoolofai.btsjmanager.teacher.controller;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.teacher.service.CollegeProgressService;
import com.ctbu.schoolofai.btsjmanager.teacher.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.teacher.service.TeacherService;
import com.ctbu.schoolofai.btsjmanager.teacher.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeacherController
{
    @Resource
    private TeacherService teacherService;
    @Resource
    private CollegeProgressService collegeProgressService;
    @Resource
    private TopicService topicService;
    @Resource
    private StudentService studentService;


    /**
     * 教师首页
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping("")
    public String  teacherSystemHome(HttpServletRequest httpServletRequest, Model model)
    {
        String trueName=(String)httpServletRequest.getSession().getAttribute("trueName");
        model.addAttribute("personalInformation",teacherService.findByTrueName(trueName));
        model.addAttribute("collegeProgress",collegeProgressService.findAll());
        model.addAttribute("systemNotification","系统公告");
        return "";
    }

    /**
     * 查询公告的详细内容
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("")
    public String systemNotification(HttpServletRequest httpServletRequest,Model model)
    {

        return "";
    }

    /**
     * 通讯录
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("")
    public String communicationBook(HttpServletRequest request ,Model model)
    {
        model.addAttribute("teacher",teacherService.findAll());
        model.addAttribute("student",studentService.findAll());
        return "";
    }



    /**
     * 个人信息
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping("")
    public String  myInformation(HttpServletRequest httpServletRequest, Model model)
    {
        String trueName=(String)httpServletRequest.getSession().getAttribute("trueName");
        model.addAttribute("personalInformation",teacherService.findByTrueName(trueName));
        return "";
    }


    /**
     * 修改密码
     * @return
     */
    @RequestMapping("")
    public  String changePassword()
    {
        return "";
    }


    /**
     * 教师出题状态-管理科学与工程学科
     * @param request
     * @param model
     * @return
     */
    public String stateOfIssue(HttpServletRequest request,Model model)
    {
        String loginName="";
        List<Topic> topics=topicService.findByCreator(loginName);
        model.addAttribute("topicInformation",topics);
        model.addAttribute("numberOfQuestions",topics.size());
        return "";
    }


    /**
     * 添加毕业毕业设计题目
     * @param request
     * @param model
     * @return
     */
    public String addTopic(HttpServletRequest request,Model model)
    {

        return "";
    }


}
