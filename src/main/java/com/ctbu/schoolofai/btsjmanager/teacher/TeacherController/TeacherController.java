package com.ctbu.schoolofai.btsjmanager.teacher.TeacherController;

import com.ctbu.schoolofai.btsjmanager.collegeProgress.service.CollegeProgressServiceImpl;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Teacher;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.student.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.teacher.service.TeacherService;
import com.ctbu.schoolofai.btsjmanager.topic.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 获取教师首页以及信息
     * @param httpServletRequest
     * @param model
     * @return
     */
    @GetMapping("/homePage")
    public String  teacherSystemHome(HttpServletRequest httpServletRequest, Model model)
    {
        Teacher teacher=(Teacher)httpServletRequest.getSession().getAttribute("loginTeacher");
        model.addAttribute("teacher",teacherService.findByTrueName(teacher.getTrueName()));
        model.addAttribute("collegeProgress",collegeProgressService.findAll());
        model.addAttribute("systemNotification","系统公告");
        return "";
    }

    /**
     * 获取教师通讯录页面以及信息
     * @param model
     * @return
     */
    @GetMapping("/addressTeacherBook")
    public String communicationTeacherBook(Model model)
    {
        model.addAttribute("teacher",teacherService.findAll());
        //model.addAttribute("student",studentService.findAll());
        return "";
    }

    /**
     * 获取学生通讯录页面以及信息
     * @param model
     * @return
     */
    @GetMapping("/addressStudentBook")
    public String communicationStudentBook(Model model)
    {
        model.addAttribute("student",studentService.findAll());
        return "";
    }

    /**
     * 获取教师个人信息页面以及个人信息
     * @param httpServletRequest
     * @param model
     * @return
     */
    @GetMapping ("/personalInformation")
    public String  myInformation(HttpServletRequest httpServletRequest, Model model)
    {
        Teacher teacher=(Teacher) httpServletRequest.getSession().getAttribute("loginTeacher");
        model.addAttribute("teacher",teacherService.findByTrueName(teacher.getLoginName()));
        return "";
    }

    /**
     * 教师修改个人信息
     * @param teacher
     * @param model
     */
    @PostMapping("/updateInformation")
    public Model updateInformation(Teacher teacher,Model model)
    {
            teacherService.save(teacher);
            model.addAttribute("teacher",teacher);
            model.addAttribute("model","修改成功");
            return model;
    }


    /**
     * 获取教师出题状态(题目信息 以及题目数量)-管理科学与工程学科  页面以及数据
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/stateOfIssue")
    public String stateOfIssue(HttpServletRequest request,Model model)
    {
        Teacher teacher=(Teacher) request.getSession().getAttribute("loginTeacher");
        List<Topic> topics=topicService.findByCreator(teacher.getLoginName());
        model.addAttribute("topicInformation",topics);
        model.addAttribute("numberOfQuestions",topics.size());
        return "";
    }

    /**
     * 获取教师添加题目页面
     * @param model
     * @return
     */
    @GetMapping("/addTopic")
    public String addTopic(Model model)
    {
        Topic topic =new Topic();
        model.addAttribute("topic",topic);
        return "";
    }

    /**
     * 保存题目
     * @param topic
     * @param model
     * @return
     */
    @PostMapping("/saveTopic")
    public  Model saveTopic(Topic topic,Model model)
    {
        topic.setState("已保存");
        topic=topicService.saveOrUpdateOrSubmitTopic(topic);
        model.addAttribute("result","保存成功");
        return model;
    }

    /**
     * 提交题目
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/submitTopic")
    public  Model submitTopic(Topic topic,Model model)
    {
        topic.setState("已提交");
        topic=topicService.saveOrUpdateOrSubmitTopic(topic);
        model.addAttribute("topic",topic);
        model.addAttribute("result","提交成功");
        return model;
    }


    /**
     * 获取毕业生选题情况页面以及数据
     * @param request
     * @return
     */
    @GetMapping("/graduateSelection")
    public  String  graduateSelection(HttpServletRequest request,Model model)
    {
        Teacher teacher=(Teacher) request.getSession().getAttribute("loginTeacher");
        List<Topic> topics = topicService.findByCreator(teacher.getLoginName());
        model.addAttribute("topics",topics);
        return "";
    }

    /**
     * 查询 所有选择该题的学生
     * @param topic
     * @param model
     * @return
     */
    @GetMapping("/viewSelectedStudents")
    public Model viewSelectedStudents(Topic topic,Model model)
    {
        List<Student> students = studentService.findByTopic(topic);
        model.addAttribute("students",students);
        return model;
    }

    /**
     * 确认学生选题
     * @param student
     * @param topic
     * @return
     */
    @PostMapping("/determineTheTopic")
    public String determineTheTopic( Student student,Topic topic)
    {
        teacherService.determineTheTopic(student,topic);
        return "确认成功";
    }



}

