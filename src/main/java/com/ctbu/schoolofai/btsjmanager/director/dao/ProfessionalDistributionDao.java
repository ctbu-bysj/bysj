package com.ctbu.schoolofai.btsjmanager.director.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.ProfessionalDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 分配出题任务数
 */
public interface ProfessionalDistributionDao extends JpaRepository<ProfessionalDistribution,String> {

    public int countAllByMajor(String major);
}
