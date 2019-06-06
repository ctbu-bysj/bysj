package com.ctbu.schoolofai.btsjmanager.student.controller;

import com.ctbu.schoolofai.btsjmanager.collegeProgress.service.CollegeProgressService;
import com.ctbu.schoolofai.btsjmanager.firstDraft.service.FirstDraftService;
import com.ctbu.schoolofai.btsjmanager.grade.service.GradeService;
import com.ctbu.schoolofai.btsjmanager.group.service.GroupService;
import com.ctbu.schoolofai.btsjmanager.midCheck.service.MidCheckService;
import com.ctbu.schoolofai.btsjmanager.paperFinalize.service.PaperFinalizeService;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.*;
import com.ctbu.schoolofai.btsjmanager.secondPaperFinalize.service.SecondPaperFinalizeService;

import com.ctbu.schoolofai.btsjmanager.secondPleaGroup.service.SecondPleaGroupService;
import com.ctbu.schoolofai.btsjmanager.student.service.StudentService;
import com.ctbu.schoolofai.btsjmanager.teacher.service.TeacherService;
import com.ctbu.schoolofai.btsjmanager.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private FirstDraftService firstDraftService;
    @Autowired
    private MidCheckService midCheckService;
    @Autowired
    private PaperFinalizeService paperFinalizeService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private SecondPaperFinalizeService secondPaperFinalizeService;
    @Autowired
    private SecondPleaGroupService secondPleaGroupService;
    @Autowired
    private CollegeProgressService  collegeProgressService;

    /**
     * 学生系统首页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/homePage")
    public  String homePage(HttpServletRequest request,Model model){
         List<CollegeProgress>   collegeProgresses=collegeProgressService.findAll();
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        model.addAttribute("student",student);
         model.addAttribute("collegeProgresses",collegeProgresses);
         return "";
    }
 @ResponseBody
 @RequestMapping("/modifyPassword")
    public  Student modifyPassword(String oldPassword,String newPassword,String reviewPassword,HttpServletRequest request){

        if(oldPassword.equals(newPassword)){
     HttpSession session= request.getSession();
     Student student =(Student) session.getAttribute("loginStudent");
     student.setLoginPwd(newPassword);
     studentService.update(student);

     Student studentNew=new Student();
     studentNew=student;
      studentNew.setLoginPwd("1");
        return studentNew;
        }
        else{
            HttpSession session= request.getSession();
            Student student =(Student) session.getAttribute("loginStudent");
            Student studentNew=new Student();
            studentNew=student;
            studentNew.setLoginPwd("0");
            return studentNew;
        }

    }

    /**
     * 修改个人信息
     * @param student
     * @param request
     * @return
     */

    @RequestMapping("/modifyPersonal")
    public  void modifyPassword( Student student,HttpServletRequest request)
    {

            studentService.update(student);

    }

    /**
     * 学生选题
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/selectTopic/{id}")
    public  String selectTopic(@PathVariable("id") long id, Model model, HttpServletRequest request){

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

    /**
     * 保存中期检查
     * @param midCheck
     * @param request
     * @return
     */
    @RequestMapping("/midCheckSave")
    public String midCheckSave(MidCheck midCheck,HttpServletRequest request){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");

        MidCheck midCheckNew= midCheckService.midCheckSave(midCheck);

        student.setMidCheck(midCheckNew);
        studentService.update(student);
        return "";
    }

    /**
     * 中期检查List
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/midCheckList")
    public  String   midCheckList(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Topic topic=topicService.findTopicById(student.getTopic().getId());
        Teacher teacher=teacherService.findById(topic.getCreator());
        model.addAttribute("teacher",teacher);
        model.addAttribute("topic",topic);
        model.addAttribute("student",student);
        return "";
    }

    /**
     * 查看中期检查
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/findMidCheck")
    public  String findMidCheck(Model model,HttpServletRequest request){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        MidCheck midCheck=  midCheckService.findMidCheck(student.getMidCheck().getMidCheckId());
         model.addAttribute("midCheck",midCheck);
        return "";
    }

    /**
     * 初稿list
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/firstDraftList")
    public  String  firstDraftList(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Topic topic=topicService.findTopicById(student.getTopic().getId());
        FirstDraft firstDraft=firstDraftService.findById(student.getFirstDraft().getFirstDraftId());
        Teacher teacher=teacherService.findById(topic.getCreator());
        model.addAttribute("teacher",teacher);
        model.addAttribute("firstDraft",firstDraft);
        model.addAttribute("topic",topic);
        model.addAttribute("student",student);
        return "";
    }

    /**
     * 初稿成绩
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/ firstDraftGrade")
    public Grade  firstDraftGrade(HttpServletRequest request){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Grade grade=student.getGrade();
        return  grade;
    }

    /**
     * 一次答辩论文定稿保存
     * @param paperFinalize
     * @param request
     * @return
     */
    @RequestMapping("/paperFinalizeSave")
    public  String  paperFinalizeSave(PaperFinalize paperFinalize,HttpServletRequest request){

       PaperFinalize paperFinalizeNew= paperFinalizeService.savePaperFinalize(paperFinalize);
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");

        student.setPaperFinalize(paperFinalizeNew);
        studentService.update(student);
        return  "";
    }

    /**
     * 一次答辩定稿list
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/paperFinalizeList")
    public  String  paperFinalizeList(Model model,HttpServletRequest request){

        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Topic topic=topicService.findTopicById(student.getTopic().getId());
         PaperFinalize paperFinalize=paperFinalizeService.findById(student.getPaperFinalize().getPaperFinalizeId());
        Teacher teacher=teacherService.findById(topic.getCreator());
        model.addAttribute("teacher",teacher);
        model.addAttribute("paperFinalize",paperFinalize);
        model.addAttribute("topic",topic);
        model.addAttribute("student",student);
        return  "";
    }

    /**
     * 一次答辩小组
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/firstPleaGroup")
   public  String firstPleaGroup(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
       Group group= groupService.findById(student.getGroup().getGroupId());
        model.addAttribute("group",group);
        return "";

   }

    /**
     * 一次答辩成绩list
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/firstPleaGradeList")
    public  String firstPleaGradeList(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Group group= groupService.findById(student.getGroup().getGroupId());
        Topic topic=topicService.findTopicById(student.getTopic().getId());
        Teacher teacher=teacherService.findById(topic.getCreator());
        model.addAttribute("teacher",teacher);
        model.addAttribute("topic",topic);
        model.addAttribute("student",student);
        model.addAttribute("group",group);

        return "";

    }

    /**
     * 一次答辩成绩
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/firstPleaGrade")
    public  String firstPleaGrade(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Grade grade=gradeService.findById(student.getGrade().getGradeId());
        model.addAttribute("grade",grade);

        return "";

    }



    /**
     * 二次答辩论文定稿保存
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/secondPaperFinalizeSave")
    public  String  secondPaperFinalizeSave(SecondPaperFinalize secondpaperFinalize,HttpServletRequest request){

        SecondPaperFinalize secondPaperFinalizeNew= secondPaperFinalizeService.savePaperFinalize(secondpaperFinalize);
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");

        student.setSecondPaperFinalize(secondPaperFinalizeNew);
        studentService.update(student);
        return  "";
    }

    /**
     * 二次答辩定稿list
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/secondPaperFinalizeList")
    public  String  secondPaperFinalizeList(Model model,HttpServletRequest request){

        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Topic topic=topicService.findTopicById(student.getTopic().getId());
        SecondPaperFinalize secondPaperFinalize=secondPaperFinalizeService.findById(student.getSecondPaperFinalize().getSecondPaperFinalizeId());
        Teacher teacher=teacherService.findById(topic.getCreator());
        model.addAttribute("teacher",teacher);
        model.addAttribute("secondPaperFinalize",secondPaperFinalize);
        model.addAttribute("topic",topic);
        model.addAttribute("student",student);
        return  "";
    }

    /**
     * 二次答辩小组
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/secondPleaGroup")
    public  String secondPleaGroup(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        SecondPleaGroup secondPleaGroup=secondPleaGroupService.findById(student.getSecondPleaGroup().getGroupId());
        model.addAttribute("secondPleaGroup",secondPleaGroup);
        return "";

    }

    /**
     * 二次答辩成绩list
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/secondPleaGradeList")
    public  String secondPleaGradeList(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        SecondPleaGroup secondPleaGroup=secondPleaGroupService.findById(student.getSecondPleaGroup().getGroupId());
        Topic topic=topicService.findTopicById(student.getTopic().getId());
        Teacher teacher=teacherService.findById(topic.getCreator());
        model.addAttribute("teacher",teacher);
        model.addAttribute("topic",topic);
        model.addAttribute("student",student);
        model.addAttribute("secondPleaGroup",secondPleaGroup);

        return "";

    }

    /**
     * 二次答辩成绩
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/secondPleaGrade")
    public  String secondPleaGrade(HttpServletRequest request,Model model){
        HttpSession session= request.getSession();
        Student student =(Student) session.getAttribute("loginStudent");
        Grade grade=gradeService.findById(student.getGrade().getGradeId());
        model.addAttribute("grade",grade);


        return "";

    }

    /*******************文档导出*******************/
    /**
     * 封面导出
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/faceExportStudent")
    public  String  faceExportStudent(HttpServletRequest request,HttpServletResponse response) throws  Exception{
        HttpSession session=request.getSession();
        Student student=(Student) session.getAttribute("loginStudent");
        File temFile;
        String  expotFile;
        Resource resource=new ClassPathResource("document/face.docx");
        temFile=resource.getFile();


        Map<String,String> map=new HashMap<String, String>();
         Student studentnew =studentService.findById(student.getStudentId());
         Teacher teacher=teacherService.findById(studentnew.getTopic().getCreator());

         Resource resourceEx=new ClassPathResource("document");
         String ex=resourceEx.getFile().getPath();
        expotFile=ex+studentnew.getStudnetName()+"face.docx";

         map.put("topic",studentnew.getTopic().getTopic());
         map.put("class",studentnew.getClasses());
         map.put("student",studentnew.getStudnetName());
         map.put("login",studentnew.getLoginName());
         map.put("teach",teacher.getTrueName());
         map.put("title",teacher.getIdentity());
         map.put("date",new Date().toString());

        studentService.exportDucment(temFile,map,expotFile);
        download(response,expotFile,studentnew.getStudnetName()+"face.docx");
        return "";
    }


    /**
     * 文件下载
     * @param response
     * @param path
     * @param fielName
     * @return
     */
    public  String download(HttpServletResponse response,String path,String fielName){

        File file=new File(path);
        if(file.exists()){
            response.setContentType("application/force-download");//强制下载不打开
            response.addHeader("Content-Disposition","attachment;fileName="+fielName);
            byte[] buffer=new byte[1024];
            FileInputStream fis=null;
            BufferedInputStream bis=null;
            try {
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
                OutputStream outputStream=response.getOutputStream();
                int i=bis.read(buffer);
                while (i!=-1){
                    outputStream.write(buffer,0,i);
                    i=bis.read(buffer);
                }
                return  "下载成功";
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(bis!=null){
                    try {
                        bis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if (fis!=null){
                    try {
                        fis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return  "下载失败";
    }
}
