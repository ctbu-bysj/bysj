package com.ctbu.schoolofai.btsjmanager.topic.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TopicDao extends JpaRepository<Topic,Long> {
    /**
     * 通过专业查找选题
     * @param pro
     * @return
     */
    List<Topic> findByChoiceProfessional(String pro);

    /**
     * 通过状态查找选题,查找已提交的题目信息
     * @param sta
     * @return
     */
    List<Topic>  findByState(String sta);

    /**
     * 查找已提交但未审核的信息，方便审核
     * @param sta
     * @return
     */
    List<Topic> findByStateAndAndApprovalStatus(String sta,String appSta);
    /**
     * 根据教师 查询教师所有出的题目
     * @param creater
     * @return
     */
    List<Topic>   findByCreator(String creater);
}
