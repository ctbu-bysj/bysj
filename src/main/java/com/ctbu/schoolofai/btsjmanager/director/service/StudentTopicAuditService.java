package com.ctbu.schoolofai.btsjmanager.director.service;

import com.ctbu.schoolofai.btsjmanager.director.dao.StudentTopicAuditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 修改审核状态
 */
@Service
public class StudentTopicAuditService {

    @Autowired
    StudentTopicAuditDao studentTopicAuditDao;

    /**
     * 所有学生选题信息
     * @return
     */
    public List<StudentTopicDo> findAll(){
        return studentTopicAuditDao.findAll();
    }


    /**
     * 更新表中的审核状态和审核意见
     * @param studentTopicDo
     * @return
     */
    public StudentTopicDo update (StudentTopicDo studentTopicDo){

        return studentTopicAuditDao.save(studentTopicDo);
    }

    /**
     * 通过审核情况查询选题信息，修改审核状态的时候使用
     * @param state
     * @return
     */
    public List<StudentTopicDo> findByState(Short state){

        return studentTopicAuditDao.findByState(state);
    }

}
