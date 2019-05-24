package com.ctbu.schoolofai.btsjmanager.director.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.TopicDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicAuditDao extends JpaRepository<TopicDo,String> {

}
