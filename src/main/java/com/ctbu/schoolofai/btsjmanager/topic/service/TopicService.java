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
    public Topic findTopicById(long id){

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


    /**
     * 保存,更新,提交题目
     * @param topic
     */
    public Topic saveOrUpdateOrSubmitTopic(Topic topic)
    {
        return topicDao.save(topic);
    }

    /**
     * 查询教师出题的信息
     * @param loginName
     * @return
     */
    public List<Topic> findByCreator(String loginName)
    {
        return topicDao.findByCreator(loginName);
    }

}
