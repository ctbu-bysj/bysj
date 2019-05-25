package com.ctbu.schoolofai.btsjmanager.teacher.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.CollegeProgress;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.CollegeProgressDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CollegeProgressService
{
    @Resource
    private CollegeProgressDao collegeProgressDao;


    /**
     * 学院进度状态检查
     * @return
     */
    public int confirmationStatus()
    {
        List<CollegeProgress> collegeProgresses= collegeProgressDao.findAll();
        int t=0;
        for(CollegeProgress collegeProgress:collegeProgresses)
        {
                Date now = new Date();

                long dataSpanS= now.getTime()-collegeProgress.getStartDate().getTime();
                long dataSpanE=collegeProgress.getEndDate().getTime()-now.getTime();
                if(dataSpanS<0)
                {
                    collegeProgress.setStatus("未开始");
                    collegeProgressDao.updateStatusById(collegeProgress.getId(),collegeProgress.getStatus());
                    t++;
                }
                if(dataSpanS>0 && dataSpanE>0)
                {
                    collegeProgress.setStatus("正在进行中");
                    collegeProgressDao.updateStatusById(collegeProgress.getId(),collegeProgress.getStatus());
                    t++;
                }
                if(dataSpanE<0)
                {
                    collegeProgress.setStatus("已经结束");
                    collegeProgressDao.updateStatusById(collegeProgress.getId(),collegeProgress.getStatus());
                    t++;
                }
        }
        return t;
    }


    /**
     * 查新学院的当前状态
     * @return
     */
    public List<CollegeProgress> findAll()
    {
        return collegeProgressDao.findAll();
    }


}
