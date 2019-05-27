package com.ctbu.schoolofai.btsjmanager.teacherAdministrator.controller;

import com.ctbu.schoolofai.btsjmanager.basicInformation.service.BasicInformationService;
import com.ctbu.schoolofai.btsjmanager.collegeProgress.service.CollegeProgressService;
import com.ctbu.schoolofai.btsjmanager.distributionCollege.service.DistributionCollegeService;
import com.ctbu.schoolofai.btsjmanager.grade.service.GradeService;
import com.ctbu.schoolofai.btsjmanager.group.service.GroupService;
import com.ctbu.schoolofai.btsjmanager.midCheck.service.MidCheckService;
import com.ctbu.schoolofai.btsjmanager.openingReport.service.OpingReportService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.*;
import com.ctbu.schoolofai.btsjmanager.stunent.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherAdministratorController {

    @Autowired
    private CollegeProgressService collegeProgressService;
    @Autowired
    private BasicInformationService basicInformationService;
    @Autowired
    private DistributionCollegeService distributionCollegeService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private StudentService studentService;
    @Resource
    private OpingReportService opingReportService;
    @Autowired
    private MidCheckService midCheckService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private GroupService groupService;
    /**
     * 保存毕业设计工作基本信息
     * @param basicInformation
     * @return
     */
 @RequestMapping("/saveBasicIn")
    public  String saveBasicIn(BasicInformation basicInformation){
              basicInformation.setCollegePro(false);
             basicInformationService.saveBasicIn(basicInformation);
             return "";

 }

    /**
     * 保存工作阶段信息
     * @param collegeProgress
     * @param model
     * @return
     */
    @RequestMapping("/saveCollegeProgress")
    public  String saveCollegeProgress(@RequestBody List<CollegeProgress>  collegeProgress, Model model){
            BasicInformation basicInformation=basicInformationService.findByCollege(false);
        for (CollegeProgress college:collegeProgress) {
             college.setBasicInformation(basicInformation);
        } 
            collegeProgressService.saveColllegePre(collegeProgress);
           return "";
    }

    /**
     * 出题任务列表
     * @param model
     * @return
     */
    @RequestMapping("/makeTopicList")
    public  String  makeTopicList(Model model){
       List<DistributionCollege> distributionColleges= distributionCollegeService.findAll();
      model.addAttribute("distributionColleges",distributionColleges);
      return "";

    }

    /**
     * 分配出题任务前数据回显
     * @param distributionCollege
     * @return
     */
    @ResponseBody
    @RequestMapping("/ assignTopicEditUi")
    public  DistributionCollege assignTopicEditUi(DistributionCollege distributionCollege){
        DistributionCollege distributionCollegeNew=distributionCollegeService.findById(distributionCollege.getId());

        return  distributionCollegeNew;
    }

    /**
     * 分配出题任务
     * @param distributionCollege
     * @return
     */
    @ResponseBody
    @RequestMapping("/assignTopic")
    public  DistributionCollege  assignTopic(DistributionCollege distributionCollege){
       DistributionCollege distributionCollegeNew=distributionCollegeService.update(distributionCollege);

       return  distributionCollegeNew;
    }

    /**
     * 教师出题管理  学科列表
     * @param model
     * @return
     */
    @RequestMapping("/teacherTopicDisList")
    public  String   teacherTopicDisList(Model model){
      List<DistributionCollege> distributionColleges=distributionCollegeService.findAll();
      model.addAttribute("distributionColleges",distributionColleges);
         return "";

    }

    /**
     * 教师出题管理  教师出题状态
     * @param model
     * @param distributionCollege
     * @return
     */
    @RequestMapping("/disTopicList")
    public  String  disTopicList(Model model,DistributionCollege distributionCollege){
        List<Topic>  topics=topicService.findByProfessional(distributionCollege.getDiscipline());
        model.addAttribute("topics",topics);
        return "";

    }

    /**
     * 教师出题管理 查看毕业设计题目
     * @param model
     * @param topic
     * @return
     */
    @RequestMapping("/findTopicDetail")
     public  String  findTopicDetail(Model model,Topic topic){
      Topic topicNew= topicService.findTopicById(topic.getId());

        model.addAttribute("topicNew",topicNew);
        return "";
     }

    /**
     * 题目审核管理 学科审核 学科列表
     * @param model
     * @return
     */
    @RequestMapping("/disAuditList")
     public  String  disAuditList(Model model){
        List<DistributionCollege> distributionColleges=distributionCollegeService.findAll();
        List  list=new ArrayList();
        int num=0;
        for (DistributionCollege dis:distributionColleges) {
            num=0;
              List<Topic> topics= topicService.findByProfessional(dis.getDiscipline());
            for ( Topic top:topics) {
                  if(top.getState().equals("1"))
                       num++;
            }
              list.add(num);
        }

        model.addAttribute("distributionColleges",distributionColleges);
        model.addAttribute("list",list);

        return "";
     }

    /**
     * 选题管理 确认选题 选题情况列表
     * @return
     */
      @RequestMapping("/selecTopicSituation")
       public  String selecTopicSituation(){
          List<Topic> topics=topicService.findAll();

          return  "";
       }

    /**
     * 选题管理 确认选题 查看毕业设计题目
     * @param topic
     * @param model
     * @return
     */
       @RequestMapping("/selecTopicSituationDetail")
       public  String selecTopicSituationDetail(Topic topic,Model model){
          List<Student> students=studentService.findByTopic(topic);
           model.addAttribute("students",students);
          model.addAttribute("topic",topic);
          return "";
    }
    /**
     * 选题管理 选题结果
     * @return
     */
    @RequestMapping("/selectTopicResult")
    public  String selectTopicResult(Model model){
        List<Topic> topics=topicService.findAll();
         List<Student> students=studentService.findAll();
         model.addAttribute("topics",topics);
        return  "";
    }

    /**
     * 开题报告管理  开题报告列表
     * @param model
     * @return
     */
    @RequestMapping("/openListTeacherAimin")
    public  String   openListTeacherAimin(Model model){
        List<Topic> topics=topicService.findAll();

        model.addAttribute("topics",topics);
        return "";
    }

    /**
     * 检查开题报告
     * @param model
     * @param student
     * @return
     */
    @RequestMapping("/openDetail")
     public  String openDetail(Model model,Student student){
            OpeingReport opeingReport=opingReportService.findByStudent(student);
            Grade grade=student.getGrade();
            model.addAttribute("opeingReport",opeingReport);
             model.addAttribute("grade",grade);
            return  "";
     }

    /**
     * 中期检查管理 中期检查列表
     * @param model
     * @return
     */
     @RequestMapping("/midCheckListTeacherAdmin")
     public  String  midCheckListTeacherAdmin(Model model){
         List<Topic> topics=topicService.findAll();

         model.addAttribute("topics",topics);
         return  "";
     }

    /**
     * 中期检查管理 中期检查查看
     * @param model
     * @param student
     * @return
     */
    @RequestMapping("/midCheckDetailTeacherAdmin")
     public  String  midCheckDetailTeacherAdmin(Model model,Student student){
         MidCheck midCheck=student.getMidCheck();
         Grade grade=student.getGrade();
        model.addAttribute("midCheck",midCheck);
        model.addAttribute("grade",grade);
         return "";
    }

    /**
     * 一次定稿检查列表
     * @param model
     * @return
     */
    @RequestMapping("/paperFinalizeListTeacherAdmin")
    public  String  paperFinalizeListTeacherAdmin(Model model){
        List<Topic> topics=topicService.findAll();

        model.addAttribute("topics",topics);
        return  "";
    }

    /**
     * 一次定稿查看
     * @param model
     * @param student
     * @return
     */
    @RequestMapping("/paperFinalizeCheckTeacherAdmin")
    public  String paperFinalizeCheckTeacherAdmin(Model model,Student student){
        Grade grade=student.getGrade();
        model.addAttribute("grade",grade);
        return "";
    }

    /**
     * 添加答辩小组
     * @param group
     * @return
     */
    @ResponseBody
    @RequestMapping("/addPaperFinalizeGroupTeacherAdmin")
    public  Group addPaperFinalizeGroupTeacherAdmin(Group group){
            Group groupNew= groupService.save(group);
        return groupNew;
    }

    /**
     *添加小组中的教师和学生
     * @param group
     * @return
     */
    @RequestMapping("/addTeacherAndStudentTeacherAdmin")
    public String addTeacherAndStudentTeacherAdmin(Group group){
        groupService.save(group);
        return  "";
    }
}
