package com.ctbu.schoolofai.btsjmanager.teacher.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.teacher.dao.TopicDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicService
{
    @Resource
    private TopicDao topicDao;


    /**
     * 查询教师出题的信息
     * @param loginName
     * @return
     */
    public List<Topic> findByCreator(String loginName)
    {
        return topicDao.findByCreator(loginName);
    }


    /**
     * 教师添加保存题目
     * @param topic
     */
    public void addTopic(Topic topic)
    {
         topic.setState("未提交");
         topicDao.save(topic);
    }

    /**
     * 教师根据ID删除题目
     * @param topicId
     */
    public void deleteTopic(String topicId)
    {
        topicDao.deleteById(topicId);
    }


}
