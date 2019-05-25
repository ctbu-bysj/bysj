package com.ctbu.schoolofai.btsjmanager.professionalDistribution.service;

import com.ctbu.schoolofai.btsjmanager.professionalDistribution.dao.ProfessionalDistributionDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.ProfessionalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalDistributionService {

    @Autowired
    ProfessionalDistributionDao professionalDistributionDao;

    /**
     * 查询所有需要分配的信息
     * @return
     */
    public List<ProfessionalDistribution> findAll(){
        return professionalDistributionDao.findAll();
    }

    /**
     * 更新每个教师的出题数
     * @param professionalDistribution
     * @return
     */
    public ProfessionalDistribution update (ProfessionalDistribution professionalDistribution){

        return professionalDistributionDao.save(professionalDistribution);
    }

    /**
     * 计算本专业的学生人数
     * @param major
     * @return
     */
    public int countByMajor(String major){
        return professionalDistributionDao.countAllByMajor(major);
    }
}
