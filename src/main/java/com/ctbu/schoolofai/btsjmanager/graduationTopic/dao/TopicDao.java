package com.ctbu.schoolofai.btsjmanager.graduationTopic.dao;

import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.ManyToOne;
import java.util.List;

public interface TopicDao extends JpaRepository<Topic,Long> {
      List<Topic>  findAllByState(String state);


}
