package com.ctbu.schoolofai.btsjmanager.professionalDistribution.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.ProfessionalDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 分配出题任务数
 */
public interface ProfessionalDistributionDao extends JpaRepository<ProfessionalDistribution,String> {

    /**
     * 通过专业统计学生人数
     * @param major
     * @return
     */
    @Query(value = "select count(o) from Student o where o.major=:major")
     int countAllByMajor(@Param("major")String major);
}
