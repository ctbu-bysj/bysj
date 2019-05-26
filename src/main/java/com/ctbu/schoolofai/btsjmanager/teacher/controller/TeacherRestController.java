package com.ctbu.schoolofai.btsjmanager.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Password;

@RestController
public class TeacherRestController
{

    /**
     * 修改个人信息
     */
    @RequestMapping("")
    public void modifyMyInformation()
    {

    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     */
    @RequestMapping("")
    public void changePassword(String oldPassword,String newPassword)
    {


    }


}
