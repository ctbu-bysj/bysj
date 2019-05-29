package com.ctbu.schoolofai.btsjmanager.topicType.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.TopicType;
import com.ctbu.schoolofai.btsjmanager.topicType.dao.TopicTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicTypeService {
   @Autowired
    private TopicTypeDao topicTypeDao;

    /**
     * 查找所有
     * @return
     */
   public List<TopicType> findAll(){
       return  topicTypeDao.findAll();
   }

    /**
     * 保存
     * @param topicType
     * @return
     */
   public  TopicType save(TopicType topicType){

       return  topicTypeDao.save(topicType);
   }

}
