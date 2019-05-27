package com.ctbu.schoolofai.btsjmanager.distributionCollege.service;


import com.ctbu.schoolofai.btsjmanager.distributionCollege.dao.DistributionCollegeDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.DistributionCollege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionCollegeServiceImpl implements DistributionCollegeService {

  @Autowired
  private DistributionCollegeDao distributionCollegeDao;
    @Override
    public List<DistributionCollege> findAll() {
        return  distributionCollegeDao.findAll();
    }

    @Override
    public DistributionCollege findById(String id) {
        return distributionCollegeDao.getOne(id);
    }

    @Override
    public DistributionCollege update(DistributionCollege distributionCollege) {
        return distributionCollegeDao.save(distributionCollege);
    }
}
