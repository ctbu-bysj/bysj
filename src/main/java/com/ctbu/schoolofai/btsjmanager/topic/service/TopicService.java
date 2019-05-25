package com.ctbu.schoolofai.btsjmanager.topic.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.topic.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicDao topicDao;
    /**
     * 查找题目通过id
     * @return
     */
    public Topic findTopicById(String id){

        return topicDao.getOne(id);

    }

   public void update(Topic topic){
        topicDao.save(topic);
    }

}
