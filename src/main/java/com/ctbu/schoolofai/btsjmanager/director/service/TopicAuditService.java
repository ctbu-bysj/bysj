package com.ctbu.schoolofai.btsjmanager.director.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 修改审核状态和审核意见
 */
@Service
public class TopicAuditService {


    @Autowired
    TopicAuditDao topicAuditDao;

    /**
     * 更新表中的审核状态和审核意见
     * @param topicDo
     * @return
     */
    public TopicDo update (TopicDo topicDo){

        return topicAuditDao.save(topicDo);
    }

    /**
     * 通过id查询题目信息，修改审核状态的时候使用
     * @param id
     * @return
     */
    public TopicDo findById(String id){

        return topicAuditDao.findById(id).orElse(null);
    }
}
