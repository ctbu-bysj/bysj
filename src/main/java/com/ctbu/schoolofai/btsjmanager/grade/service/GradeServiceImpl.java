package com.ctbu.schoolofai.btsjmanager.grade.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeService gradeService;

    @Override
    public Grade findById(String id) {
        return gradeService.findById(id);
    }
}
