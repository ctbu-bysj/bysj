package com.ctbu.schoolofai.btsjmanager.topic.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopicDao extends JpaRepository<Topic,Long> {
    /**
     * 通过专业查找选题
     * @param pro
     * @return
     */
    List<Topic> findByChoiceProfessional(String pro);

    /**
     * 通过状态查找选题
     * @param sta
     * @return
     */
    List<Topic>  findByState(String sta);

    /**
     * 根据教师 查询教师所有出的题目
     * @param creater
     * @return
     */
    List<Topic>   findByCreator(String creater);
}
