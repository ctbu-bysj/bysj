package com.ctbu.schoolofai.btsjmanager.director.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.topic.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 修改审核状态和审核意见
 */
@Service
public class TopicAuditService {


    @Autowired
    TopicDao topicDao;

    public List<Topic> findAll(){
        return topicDao.findAll();
    }

    /**
     * 更新表中的审核状态和审核意见
     * @param topicDo
     * @return
     */
    public Topic update (Topic topicDo,String selection,String opinion){

        if(selection.equals("通过")) {
            topicDo.setApprovalStatus("已审核");
            topicDo.setAuditOpinion(opinion);  //修改审核意见
        }
        else {
            topicDo.setState("未提交");   //审核不通过，教师重新提交
            topicDo.setApprovalStatus(null);
        }
        return topicDao.save(topicDo);
    }

    /**
     * 返回所有已经提交但未审核的信息，修改审核状态的时候使用
     * @param sta
     * @return
     */
    public List<Topic> findByStateAndApprovalStatus(String sta,String appSta){

        return topicDao.findByStateAndAndApprovalStatus(sta,appSta);
    }

    /**
     * 返回所有提交的题目信息
     * @param sta
     * @return
     */
    public List<Topic> findByState(String sta){

        return topicDao.findByState(sta);
    }
}
