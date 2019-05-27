package com.ctbu.schoolofai.btsjmanager.topic.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.topic.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 更新选题
     * @param topic
     */
   public void update(Topic topic){
        topicDao.save(topic);
    }

    /**
     * 查找选题通过专业
     * @param pro
     * @return
     */
    public List<Topic>  findByProfessional(String  pro){
       return  topicDao.findByChoiceProfessional(pro);
    }

    /**
     * 通过状态查找
     * @param sta
     * @return
     */
    public  List<Topic>  findByState(String sta){

        return topicDao.findByState(sta);
    }

    /**
     * 查找所有
     * @return
     */
  public   List<Topic> findAll(){
        return  topicDao.findAll();
    }

}
