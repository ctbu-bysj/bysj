package com.ctbu.schoolofai.btsjmanager.director.service;

import com.ctbu.schoolofai.btsjmanager.director.dao.TopicAuditDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 修改审核状态和审核意见
 */
@Service
public class TopicAuditService {


    @Autowired
    TopicAuditDao topicAuditDao;

    public List<Topic> findAll(){
        return topicAuditDao.findAll();
    }

    /**
     * 更新表中的审核状态和审核意见
     * @param topicDo
     * @return
     */
    public Topic update (Topic topicDo){

        return topicAuditDao.save(topicDo);
    }

    /**
     * 通过审核情况查询选题信息，修改审核状态的时候使用
     * @param state
     * @return
     */
    public List<Topic> findByState(Short state){

        return topicAuditDao.findByState(state);
    }
}
