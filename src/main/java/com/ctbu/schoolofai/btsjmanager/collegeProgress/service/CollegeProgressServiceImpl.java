package com.ctbu.schoolofai.btsjmanager.collegeProgress.service;

import com.ctbu.schoolofai.btsjmanager.collegeProgress.dao.CollegeProgressDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.CollegeProgress;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeProgressServiceImpl implements CollegeProgressService {

    @Autowired
    private  CollegeProgressDao  collegeProgressDao;
    @Override
    public List<CollegeProgress> findAll() {
        return  collegeProgressDao.findAll();
    }

    @Override
    public List<CollegeProgress>  saveColllegePre(Iterable<CollegeProgress> collegeProgress) {
        return collegeProgressDao.saveAll(collegeProgress);
    }
}
