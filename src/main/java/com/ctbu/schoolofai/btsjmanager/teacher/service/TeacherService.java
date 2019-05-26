package com.ctbu.schoolofai.btsjmanager.teacher.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Teacher;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.StudentDao;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.TeacherDao;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.TopicDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService
{

    @Resource
    private TeacherDao teacherDao;

    @Resource
    private StudentDao studentDao;

    @Resource
    private TopicDao topicDao;


    /**
     * 根据登录名（工号）查询教师个人信息
     * @param loginName
     * @return
     */
    public Teacher  teacherInformation(String loginName)
    {
        return teacherDao.findByLoginName(loginName);
    }

    /**
     * 根据教师的id增加登录次数
     * @param id
     * @return
     */
    @Transactional
    public int  updateLoginTimes(String id)
    {
        return teacherDao.updateLoginTimes(id);
    }

    /**
     * 查询所有教师信息 （通讯录）
     * @return
     */
    public List<Teacher> findAll()
    {
        return  teacherDao.findAll();
    }

    /**
     * 根据教师真实姓名查询所以的教师（通讯录）
     * @param trueName
     * @return
     */
    public List<Teacher> findByTrueName(String trueName)
    {
        return teacherDao.findByTrueName(trueName);
    }

    /**
     * 根据学科查询所以的教师（通讯录）
     * @param subject
     * @return
     */
    public List<Teacher> findBySubject(String subject)
    {
        return  teacherDao.findBySubject(subject);
    }

    /**
     * 教师修改个人信息
     * @param qq
     * @param tel
     * @param id
     * @return
     */
    @Transactional
    public int  updateInformation(String qq,String tel,String id)
    {
        return teacherDao.updateInformation(qq,tel,id);
    }

    /**
     * 教师修改登录密码
     * @param password
     * @param id
     * @return
     */
    @Transactional
    public int updateInformation(String password ,String id)
    {
        return teacherDao.updataPassword(password,id);
    }


    /**
     * 通过id查询教师
     * @param id
     * @return
     */
   public Teacher findById(String id){
        return teacherDao.getOne(id);
   }


    /**
     * 查询所有选择该教师所出题目的学生（根据教师（教师出题的ID）
     * @param loginName
     * @return
     */
   public List<Student> studentSelection(String loginName)
   {
       List<Topic> topics=topicDao.findByCreator(loginName);
       List<Student> students=new ArrayList<>();
       List<Student> students1;
       for(Topic t:topics)
       {
           students1=studentDao.findByTopic_Id(t.getId());
           students.addAll(students1);
       }
       return students;
   }

    /**
     * 教师确认选题
     * @param studentId
     */
    @Transactional
    public void  confirmStudentSelection(String studentId)
    {
       if(studentDao.findByStudentId(studentId).getTopic().getRemainingQuota()>0)
       {
           topicDao.updateRemainingQuota(studentId);
           studentDao.updateTeacherDeterminesStatus("已确认", studentId);
       }
   }


}
