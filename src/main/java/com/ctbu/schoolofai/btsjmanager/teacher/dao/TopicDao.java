package com.ctbu.schoolofai.btsjmanager.teacher.dao;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TopicDao extends JpaRepository<Topic,String>
{

    /**
     * 通过出题老师的登录名查询其所有出题信息
     * @param loginName
     * @return
     */
    List<Topic>  findByCreator(String loginName);




    /**
     * 提交题目
     * @param topicId
     * @return
     */
     @Query(value = "update Topic t set t.state = '已提交' where t.id=:id")
     @Modifying
     int submitTopic(String topicId);

    /**
     * 教师确定选题 减少题目容量
     * @param id
     */
     @Modifying
     @Query(value = "update Topic  t set t.remainingQuota = t.remainingQuota - 1 where t.id  =  :id")
     void updateRemainingQuota(@Param("id") String id);





}
