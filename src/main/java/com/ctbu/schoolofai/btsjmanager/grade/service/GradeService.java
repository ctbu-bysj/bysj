package com.ctbu.schoolofai.btsjmanager.grade.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface GradeService{
    /**
     * 通过id查询成绩
     * @param id
     * @return
     */
    Grade findById(long id);

}
