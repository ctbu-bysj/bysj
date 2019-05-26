package com.ctbu.schoolofai.btsjmanager.teacher.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService
{
    @Resource
    private StudentDao studentDao;

    /**
     * 查询所有学生基本信息
     * @return
     */
    public List<Student> findAll()
    {
        return studentDao.findAll();
    }
}
