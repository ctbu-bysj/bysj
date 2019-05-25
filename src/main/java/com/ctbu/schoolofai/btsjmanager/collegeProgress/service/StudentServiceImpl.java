package com.ctbu.schoolofai.btsjmanager.collegeProgress.service;

import com.ctbu.schoolofai.btsjmanager.collegeProgress.dao.StudentDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public String  update(Student student){

        Student student1= studentDao.save(student);

        if (student1.getTopic().getId()!=null)
            return  "true";

         else return null;

    }

    @Override
    public Student findById(String id) {
        return studentDao.getOne(id);
    }
}
