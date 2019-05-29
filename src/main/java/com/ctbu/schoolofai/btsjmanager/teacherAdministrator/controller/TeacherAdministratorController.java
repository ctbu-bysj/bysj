package com.ctbu.schoolofai.btsjmanager.teacherAdministrator.controller;

import com.ctbu.schoolofai.btsjmanager.SoftwareTechnology.service.SoftwareTechnologyService;
import com.ctbu.schoolofai.btsjmanager.basicInformation.service.BasicInformationService;
import com.ctbu.schoolofai.btsjmanager.collegeProgress.service.CollegeProgressService;
import com.ctbu.schoolofai.btsjmanager.database.service.DatabaseService;
import com.ctbu.schoolofai.btsjmanager.discipline.service.DiscilineService;
import com.ctbu.schoolofai.btsjmanager.distributionCollege.service.DistributionCollegeService;
import com.ctbu.schoolofai.btsjmanager.grade.service.GradeService;
import com.ctbu.schoolofai.btsjmanager.group.service.GroupService;
import com.ctbu.schoolofai.btsjmanager.midCheck.service.MidCheckService;
import com.ctbu.schoolofai.btsjmanager.openingReport.service.OpingReportService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.*;
import com.ctbu.schoolofai.btsjmanager.resultsForm.service.ResultsFormService;
import com.ctbu.schoolofai.btsjmanager.secondPleaGroup.service.SecondPleaGroupService;
import com.ctbu.schoolofai.btsjmanager.student.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.teacher.service.TeacherService;
import com.ctbu.schoolofai.btsjmanager.topic.service.TopicService;
import com.ctbu.schoolofai.btsjmanager.topicType.service.TopicTypeService;
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
    @Autowired
    private SecondPleaGroupService secondPleaGroupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DiscilineService discilineService;
    @Autowired
    private SoftwareTechnologyService softwareTechnologyService;
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private TopicTypeService topicTypeService;
    @Autowired
    private  ResultsFormService  resultsFormService;
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

    /**
     * 一次答辩管理 一次答辩成绩管理
     * @param model
     * @return
     */
    @RequestMapping("/paperFinalizeGradeTeacherAdmin")
    public String paperFinalizeGradeTeacherAdmin(Model model){
        List<Topic> topics=topicService.findAll();
        List<Student> students=studentService.findAll();
        model.addAttribute("topics",topics);
        model.addAttribute("students",students);
        return "";
    }

    /**
     * 一次答辩管理 成绩查看
     * @param student
     * @param model
     * @return
     */
    @RequestMapping("/paperFinalizeGradeCheckTeacherAdmin")
    public  String  paperFinalizeGradeCheckTeacherAdmin(Student student,Model model){
       Student studentNew=  studentService.findById(student.getStudentId());
        model.addAttribute("studentNew",studentNew);
        return "";
    }





    /**
     * 二次定稿检查列表
     * @param model
     * @return
     */
    @RequestMapping("/SecondPaperFinalizeListTeacherAdmin")
    public  String  SecondPaperFinalizeListTeacherAdmin(Model model){
        List<Topic> topics=topicService.findAll();

        model.addAttribute("topics",topics);
        return  "";
    }

    /**
     * 二次定稿查看
     * @param model
     * @param student
     * @return
     */
    @RequestMapping("/secondPaperFinalizeCheckTeacherAdmin")
    public  String secondPaperFinalizeCheckTeacherAdmin(Model model,Student student){
        Grade grade=student.getGrade();
        model.addAttribute("grade",grade);
        return "";
    }

    /**
     * 二次答辩添加答辩小组
     * @param secondPleaGroup 小组
     * @return
     */
    @ResponseBody
    @RequestMapping("/addSecondPaperFinalizeGroupTeacherAdmin")
    public  SecondPleaGroup addSecondPaperFinalizeGroupTeacherAdmin(SecondPleaGroup secondPleaGroup){
        SecondPleaGroup secondPleaGroupNew=secondPleaGroupService.save(secondPleaGroup);
        return secondPleaGroupNew;
    }

    /**
     *添加小组中的教师和学生
     * @param secondPleaGroup
     * @return
     */
    @RequestMapping("/addTeacherAndStudentTeacherAdmin")
    public String addTeacherAndStudentTeacherAdmin(SecondPleaGroup secondPleaGroup){
         secondPleaGroupService.save(secondPleaGroup);
        return  "";
    }

    /**
     * 二次答辩管理 二次答辩成绩管理
     * @param model
     * @return
     */
    @RequestMapping("/secondPaperFinalizeGradeTeacherAdmin")
    public String secondPaperFinalizeGradeTeacherAdmin(Model model){
        List<Topic> topics=topicService.findAll();
        List<Student> students=studentService.findAll();
        model.addAttribute("topics",topics);
        model.addAttribute("students",students);
        return "";
    }

    /**
     * 二次答辩管理 成绩查看
     * @param student
     * @param model
     * @return
     */
    @RequestMapping("/secondPaperFinalizeGradeCheckTeacherAdmin")
    public  String  secondPaperFinalizeGradeCheckTeacherAdmin(Student student,Model model){
        Student studentNew=  studentService.findById(student.getStudentId());
        model.addAttribute("studentNew",studentNew);
        return "";
    }

    /**
     * 论文检查管理  查重论文列表
     * @param model
     * @return
     */
    @RequestMapping("/recheckRateListTeacherAdmin")
    public  String recheckRateListTeacherAdmin(Model model){
        List<Topic> topics=topicService.findAll();
        List<Student> students=studentService.findAll();
        model.addAttribute("topics",topics);
        model.addAttribute("students",students);
        return "";
    }

    /**
     * 论文检查管理  查重录入
     * @param student
     * @param rate
     * @return
     */
    @RequestMapping("/recheckRateEntryTeacherAdmin")
    public  Grade  recheckRateEntryTeacherAdmin(Student student,String rate){
        Student studentNew=studentService.findById(student.getStudentId());
           studentNew.getGrade().setRecheckRate(rate);
           studentService.update(studentNew);
           return   studentNew.getGrade();
    }

    /**
     * 论文检查管理  查格式列表
     * @param model
     * @return
     */
    @RequestMapping("/paperFormatListTeacherAdmin")
    public  String  paperFormatListTeacherAdmin(Model model){
        List<Topic> topics=topicService.findAll();
        List<Student> students=studentService.findAll();
        model.addAttribute("topics",topics);
        model.addAttribute("students",students);
        return "";
    }

    /**
     * 格式录入
     * @param student
     * @param rate
     * @return
     */
    @RequestMapping("/paperFormatTeacherAdmin")
    public   Grade  paperFormatTeacherAdmin(Student student,String rate){
        Student studentNew=studentService.findById(student.getStudentId());
        studentNew.getGrade().setRecheckRate(rate);
        studentService.update(studentNew);
        return   studentNew.getGrade();
  }


  /**********************人员管理***********************************/
    /**
     * 管理人员综合管理 人员列表
     * @param model
     * @return
     */
  @RequestMapping("/teacherListTeacherAdmin")
   public  String  teacherListTeacherAdmin(Model model){
       List<Teacher> teachers=teacherService.findAll();
         model.addAttribute("teachers",teachers);
         return  "";
  }

    /**
     * 管理人员综合管理 添加
     * @param teacher
     * @return
     */
    @RequestMapping("/addAllTeacherTeacherAdmin")
    public  String addAllTeacherTeacherAdmin(Teacher teacher){

      teacherService.save(teacher);

      return "";

  }

    /**
     * 教学人员管理 列表
     * @param status
     * @param model
     * @return
     */
    @RequestMapping("/findBySystemStatus")
    public  String findBySystemStatus(String status,Model model){
             List<Teacher> teachers=teacherService.findBySystemStatus(status);
              model.addAttribute("teachers",teachers);
              return  "";
  }

    /**
     * 添加教学管理员
     * @param teacher
     * @return
     */
    @RequestMapping("/addTeacheradminTeacherAdmin")
    public  String addTeacheradminTeacherAdmin(Teacher teacher){
         teacherService.save(teacher);

        return  "";
  }

    /**
     * 学科负责人管理 列表
     * @param status
     * @param model
     * @return
     */
    @RequestMapping("/disciplineLeaderListTeacherAdmin")
    public String disciplineLeaderListTeacherAdmin(String status,Model model){
        List<Teacher> teachers=teacherService.findBySystemStatus(status);
        model.addAttribute("teachers",teachers);
        return  "";
    }

    /**
     * 添加学科负责人
     * @param teacher
     * @return
     */
    @RequestMapping("/addDisciplineLeaderTeacherAdmin")
    public  String addDisciplineLeaderTeacherAdmin(Teacher teacher){
        teacherService.save(teacher);

        return  "";
    }

    /**
     * 答辩评委管理 列表
     * @param role
     * @param model
     * @return
     */
    @RequestMapping("/judgeListTeacherAdmin")
    public  String   judgeListTeacherAdmin(Role role,Model model){
        List<Teacher> teachers= teacherService.findByRole(role);
         model.addAttribute("teachers",teachers);
        return  "";
    }

    /**
     * 答辩评委管理 添加
     * @param teacher
     * @return
     */
    @RequestMapping("/addJudgeTeacherAdmin")
    public  String addJudgeTeacherAdmin(Teacher teacher){
        teacherService.save(teacher);

        return  "";
    }

    /**
     * 教师管理 教师列表
     * @param role
     * @return
     */
    @RequestMapping("/teacherListTeacherAdmin")
    public  String teacherListTeacherAdmin(Role role){
        teacherService.findByRole(role);

        return  "";
    }

    /**
     * 教师管理 添加教师
     * @param teacher
     * @return
     */
    @RequestMapping("/addTeacherTeacherAdmin")
    public  String addTeacherTeacherAdmin(Teacher teacher){
        teacherService.save(teacher);

        return "";
    }

    /**
     * 毕业生管理 列表
     * @param model
     * @return
     */
    @RequestMapping("/studentListTeacherAdmin")
    public  String studentListTeacherAdmin(Model model){
         List<Student> students=studentService.findAll();
        model.addAttribute("students",students);
        return "";
    }

    /**
     * 毕业生管理 添加学生
     * @param student
     * @return
     */
    @RequestMapping("/addStudentTeacherAdmin")
    public  String addStudentTeacherAdmin(Student student){
        studentService.save(student);
        return "";
    }

    /**
     * 学科管理 学科列表
     * @param model
     * @return
     */
    @RequestMapping("/discipineListTeacherAdmin")
    public  String  discipineListTeacherAdmin(Model model){
        List<Discipline> disciplines=discilineService.findAll();
        model.addAttribute("disciplines",disciplines);
        return  "";
    }

    /**
     * 学科管理 添加
     * @param discipline
     * @return
     */
    @RequestMapping("/addDiscipineTeacherAdmin")
    public  String addDiscipineTeacherAdmin(Discipline discipline){
        discilineService.save(discipline);

        return  "";
    }

    /************************系统设置******************/
    /**
     * 软件开发技术管理 列表
     * @param model
     * @return
     */
    @RequestMapping("/softwareTechnologyListTeacherAdmin")
    public  String  softwareTechnologyListTeacherAdmin(Model model){
         List<SoftwareTechnology> softwareTechnologies=softwareTechnologyService.findAll();

         model.addAttribute("softwareTechnologies",softwareTechnologies);
         return "";

    }

    /**
     * 软件开发技术管理 添加
     * @param softwareTechnology
     * @return
     */
    @RequestMapping("/addSoftwareTechnologyTeacherAdmin")
    public  String addSoftwareTechnologyTeacherAdmin(SoftwareTechnology softwareTechnology){

        softwareTechnologyService.save(softwareTechnology);

        return  "";
    }

    /**
     * 数据库管理 列表
     * @param model
     * @return
     */
    @RequestMapping("/databaseListTeacherAdmin")
   public  String  databaseListTeacherAdmin(Model model){

        List<Database> databases=databaseService.findAll();
        model.addAttribute("databases",databases);
        return "";
   }

    /**
     * 数据库管理 添加
     * @param database
     * @return
     */
   @RequestMapping("/addDatabaseTeacherAdmin")
    public String addDatabaseTeacherAdmin(Database database) {
        databaseService.save(database);

        return "";
   }

    /**
     * 题目类型管理 列表
     * @param model
     * @return
     */
    @RequestMapping("/topicTypeListTeacherAdmin")
    public  String  topicTypeListTeacherAdmin(Model model){
       List<TopicType> topicTypes=topicTypeService.findAll();
       model.addAttribute("topicTypes",topicTypes);

       return  "";
   }

    /**
     * 题目类型管理 添加
     * @param topicType
     * @return
     */
      @RequestMapping("/addTopicTypeTeacherAdmin")
       public  String  addTopicTypeTeacherAdmin(TopicType topicType){
        topicTypeService.save(topicType);
        return  "";
    }

    /**
     * 作品形式管理 列表
     * @param model
     * @return
     */
    @RequestMapping("/resultsFormListTeacherAdmin")
    public  String  resultsFormListTeacherAdmin(Model model){
          List<ResultsForm> resultsForms=resultsFormService.findAll();
          model.addAttribute("resultsForms",resultsForms);
           return "";

    }

    /**
     * 作品形式管理 保存
     * @param resultsForm
     * @return
     */
    @RequestMapping("/addResultsFormTeacherAdmin")
    public  String addResultsFormTeacherAdmin(ResultsForm resultsForm){

        resultsFormService.save(resultsForm);
        return "";
    }

}

