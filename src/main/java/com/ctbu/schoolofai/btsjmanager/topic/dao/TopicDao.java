package com.ctbu.schoolofai.btsjmanager.topic.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicDao extends JpaRepository<Topic,String> {

}
