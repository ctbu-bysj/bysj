package com.ctbu.schoolofai.btsjmanager.teacher.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Role;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher,String>
{
    /**
     * 根据教师登录名（工号）查询该老师所有的信息
     * @param loginName
     * @return
     */
    public Teacher findByLoginName(String loginName);


    /**
     * 查询所有的教师
     * @return
     */
    public List<Teacher> findAll();


    /**
     * 通过教师真是姓名查询教师
     * @param trueName
     * @return
     */
    public List<Teacher> findByTrueName(String trueName);


    /**
     * 根据学科科目查询教师
     * @param subject
     * @return
     */
    public List<Teacher> findBySubject(String subject);


    /**
     * 根据用户id增加教师登录次数
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update Teacher t set t.loginTimes = t.loginTimes + 1  where t.id=:id")
    public int updateLoginTimes(@Param("id") String id);


    /**
     * 教师个人信息修改
     * @param qq
     * @param tel
     * @return
     */
    @Modifying
    @Query(value = "update Teacher t set t.qq = :qq , t.tel=:tel where t.id=:id")
    public int updateInformation(@Param("qq") String qq, @Param("tel") String tel, @Param("id") String id);

    /**
     *教师修改个人密码
     * @param password
     * @return
     */
    @Modifying
    @Query(value = "update Teacher t set t.password = :password where t.id =:id")
    public int updataPassword(@Param("password") String password, @Param("id") String id);

    /**
     * 通过系统身份查找
     * @param systemStatus
     * @return
     */
    List<Teacher>  findBySystemStatus(String systemStatus);

    /**
     * 通过角色查找
     * @param role
     * @return
     */
    List<Teacher>  findByRoles(Role role);

}
