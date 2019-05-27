package com.ctbu.schoolofai.btsjmanager.distributionCollege.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.DistributionCollege;

import java.util.List;

public interface DistributionCollegeService {
    /**
     * 查找所有
     * @return
     */
    List<DistributionCollege> findAll();

    /**
     * 通过id查找
     * @param id
     * @return
     */
    DistributionCollege findById(String id);

    /**
     * 更新
     * @param distributionCollege
     * @return
     */
    DistributionCollege update(DistributionCollege distributionCollege);


}
