package com.ctbu.schoolofai.btsjmanager.graduationTopic.service;

import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;

import java.util.List;

public interface TopicService {
    /**
     * 查询已审核通过题目
     * @param state
     * @return
     */
    public List<Topic> findTopicByState(String state);

    /**
     * 通过id查询题目
     * @param id
     * @return
     */
    public  Topic findTopicById(Long id);

    /**
     * g更新选题
     * @param topic
     */
    public void update(Topic topic);
}
