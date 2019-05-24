package com.ctbu.schoolofai.btsjmanager.instructor.dao;

import com.ctbu.schoolofai.btsjmanager.instructor.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicDao extends JpaRepository<Topic,String>
{

}
