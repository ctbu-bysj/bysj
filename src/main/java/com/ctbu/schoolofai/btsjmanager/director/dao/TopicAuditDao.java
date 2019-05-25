package com.ctbu.schoolofai.btsjmanager.director.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicAuditDao extends JpaRepository<Topic,String> {

}
