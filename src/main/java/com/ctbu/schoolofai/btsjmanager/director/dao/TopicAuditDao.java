package com.ctbu.schoolofai.btsjmanager.director.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 出题审核
 */
public interface TopicAuditDao extends JpaRepository<Topic,String> {

    @Query(value = "select o from Topic o where o.approvalStatus=:state")//书写查询语句
    public List<Topic> findByState(@Param("approvalStatus") Short state);

}
