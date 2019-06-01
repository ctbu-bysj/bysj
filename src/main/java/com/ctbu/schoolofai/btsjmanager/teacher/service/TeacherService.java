package com.ctbu.schoolofai.btsjmanager.teacher.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Role;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Teacher;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.TeacherDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService
{

    @Resource
    private TeacherDao teacherDao;


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
    public int updateInformation(String password ,String id)
    {
        return teacherDao.updataPassword(password,id);
    }

    /**
     * 通过id查询教师
     * @param id
     * @return
     */
   public Teacher findById(long id){
        return teacherDao.getOne(id);
   }

    /**
     * 添加教师
     * @param teacher
     * @return
     */
   public  Teacher save(Teacher teacher){

       return  teacherDao.save(teacher);
   }

    /**
     * 通过身份查找
     * @param status
     * @return
     */
   public  List<Teacher> findBySystemStatus(String status){
       return  teacherDao.findBySystemStatus(status);
   }

    /**
     * 通过角色查找
     * @param role
     * @return
     */
    public  List<Teacher> findByRole(Role role){
       return  teacherDao.findByRoles(role);
    }

}
