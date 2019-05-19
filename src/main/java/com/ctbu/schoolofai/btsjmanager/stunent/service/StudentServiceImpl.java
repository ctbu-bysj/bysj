package com.ctbu.schoolofai.btsjmanager.stunent.service;

import com.ctbu.schoolofai.btsjmanager.stunent.dao.StudentDao;
import com.ctbu.schoolofai.btsjmanager.stunent.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    private StudentDao studentDao;

    public String  update(Student student){

        Student  student1= studentDao.save(student);

        if (student1.getTopic().getTopicId()!=null)
            return  "true";

         else return null;

    }
}
