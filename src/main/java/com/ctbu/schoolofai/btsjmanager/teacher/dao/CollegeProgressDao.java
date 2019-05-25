package com.ctbu.schoolofai.btsjmanager.teacher.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.CollegeProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollegeProgressDao extends JpaRepository<CollegeProgress,String>
{
    /**
     * 查询所有的阶段状态
     * @return
     */
    List<CollegeProgress> findAll();


    /**
     * 根据Id修改阶段的状态
     * @param id
     * @param status
     */
    @Modifying
    @Query(value = "update CollegeProgress cl set cl.status = :status where cl.id = :id")
    int updateStatusById(@Param("id") String id, @Param("name") String status);




}
