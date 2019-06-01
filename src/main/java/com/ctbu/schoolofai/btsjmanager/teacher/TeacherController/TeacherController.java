package com.ctbu.schoolofai.btsjmanager.teacher.TeacherController;

import com.ctbu.schoolofai.btsjmanager.collegeProgress.service.CollegeProgressServiceImpl;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Teacher;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.student.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.student.service.StudentServiceImpl;
import com.ctbu.schoolofai.btsjmanager.teacher.service.TeacherService;
import com.ctbu.schoolofai.btsjmanager.topic.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController
{
    @Resource
    private TeacherService teacherService;
    @Resource
    private CollegeProgressServiceImpl collegeProgressService;
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
    @RequestMapping("/homePage")
    public String  teacherSystemHome(HttpServletRequest httpServletRequest, Model model)
    {
        Teacher teacher=(Teacher)httpServletRequest.getSession().getAttribute("loginTeacher");
        model.addAttribute("personalInformation",teacherService.findByTrueName(teacher.getTrueName()));
        model.addAttribute("collegeProgress",collegeProgressService.findAll());
        model.addAttribute("systemNotification","系统公告");
        return "";
    }

    /**
     * 通讯录
     * @param model
     * @return
     */
    @RequestMapping("/addressBook")
    public String communicationBook(Model model)
    {
        model.addAttribute("teacher",teacherService.findAll());
        //model.addAttribute("student",studentService.findAll());
        return "";
    }

    /**
     * 个人信息
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping("/personalInformation")
    public String  myInformation(HttpServletRequest httpServletRequest, Model model)
    {
        Teacher teacher=(Teacher) httpServletRequest.getSession().getAttribute("loginTeacher");
        model.addAttribute("personalInformation",teacherService.findByTrueName(teacher.getLoginName()));
        return "";
    }

    /**
     * 教师出题状态(题目信息 以及题目数量)-管理科学与工程学科
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/stateOfIssue")
    public String stateOfIssue(HttpServletRequest request,Model model)
    {
        Teacher teacher=(Teacher) request.getSession().getAttribute("loginTeacher");
        List<Topic> topics=topicService.findByCreator(teacher.getLoginName());
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
    @RequestMapping("/addTopic")
    public String addTopic(HttpServletRequest request,Model model)
    {
        return "";
    }

    /**
     * 保存题目
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveTopic")
    public  String saveTopic(HttpServletRequest request,Model model)
    {
        Topic topic =new Topic();
        topic.setState("已保存");
        topic=topicService.saveOrUpdateOrSubmitTopic(topic);
        model.addAttribute("topic",topic);
        return "";
    }

    /**
     * 提交题目
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/submitTopic")
    public  String submitTopic(HttpServletRequest request,Model model)
    {
        Topic topic =new Topic();
        topic.setState("已提交");
        topic=topicService.saveOrUpdateOrSubmitTopic(topic);
        model.addAttribute("topic",topic);
        return "";
    }


    /**
     * 毕业生选题情况
     * @param request
     * @return
     */
    @RequestMapping("/graduateSelection")
    public  String  graduateSelection(HttpServletRequest request,Model model)
    {
        Teacher teacher=(Teacher) request.getSession().getAttribute("loginTeacher");
        List<Topic> topics = topicService.findByCreator(teacher.getLoginName());
        model.addAttribute("topics",topics);
        return "";
    }

    /**
     * 查询 所有选择该题的学生
     * @param request
     * @param model
     * @param topic
     * @return
     */
    @RequestMapping("viewSelectedStudents")
    public String viewSelectedStudents(HttpServletRequest request,Model model,Topic topic)
    {
        List<Student> students = studentService.findByTopic(topic);
        model.addAttribute("students",students);
        return "";
    }

    public String determineTheTopic(Student student)
    {
        return "";
    }

}

