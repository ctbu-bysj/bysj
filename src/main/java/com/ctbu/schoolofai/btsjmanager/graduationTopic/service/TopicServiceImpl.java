package com.ctbu.schoolofai.btsjmanager.graduationTopic.service;

import com.ctbu.schoolofai.btsjmanager.graduationTopic.dao.TopicDao;
import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl  implements TopicService{

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> findTopicByState(String state) {
        return topicDao.findAllByState(state);
    }

    @Override
    public  Topic findTopicById(Long id) {
        return topicDao.findById(id).get();
    }

    @Override
    public void update(Topic topic) {
        topicDao.save(topic);
    }
}
