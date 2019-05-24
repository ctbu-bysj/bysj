package com.ctbu.schoolofai.btsjmanager.director.service;

import com.ctbu.schoolofai.btsjmanager.director.dao.TopicAuditDao;
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

    public List<TopicDo> findAll(){
        return topicAuditDao.findAll();
    }

    /**
     * 更新表中的审核状态和审核意见
     * @param topicDo
     * @return
     */
    public TopicDo update (TopicDo topicDo){

        return topicAuditDao.save(topicDo);
    }

    /**
     * 通过审核情况查询选题信息，修改审核状态的时候使用
     * @param state
     * @return
     */
    public List<TopicDo> findByState(Short state){

        return topicAuditDao.findByState(state);
    }
}
