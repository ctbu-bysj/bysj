package com.ctbu.schoolofai.btsjmanager.collegeProgress.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.CollegeProgress;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface CollegeProgressService {
    /**
     * 查找所有阶段
     * @return
     */
    List<CollegeProgress>  findAll();

    /**
     * 保存毕业设计工作阶段
     * @param collegeProgress
     * @return
     */
    List<CollegeProgress>  saveColllegePre(  Iterable<CollegeProgress>   collegeProgress);

}
