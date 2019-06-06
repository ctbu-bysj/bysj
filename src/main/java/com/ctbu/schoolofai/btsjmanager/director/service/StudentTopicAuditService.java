package com.ctbu.schoolofai.btsjmanager.director.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Teacher;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import com.ctbu.schoolofai.btsjmanager.student.dao.StudentDao;
import com.ctbu.schoolofai.btsjmanager.topic.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 修改审核状态
 */
@Service
public class StudentTopicAuditService {

    @Resource
    StudentDao studentDao;

    @Autowired
    TopicDao topicDao;
    /**
     * 所有学生选题信息
     * @return
     */
    public List<Student> findAll(){
        return studentDao.findAll();
    }


    /**
     * 确定教师和学生选题双选情况
     * @param student
     * @return
     */
    public Student update (Student student,String selection){

        if(selection.equals("通过")) {
            student.setDeterminesStatus("学科负责人已确认");
        }
        else {
            student.setTopic(null);  //让学生可以重新选择题目
            student.setDeterminesStatus("未选择");
        }
        return studentDao.save(student);
    }

    /**
     * 查找学生和教师都同意的选题情况
     * @param state
     * @return
     */
    public List<Student> findByDeterminesStatus(String state){

        List<Student> students = studentDao.findByDeterminesStatus(state);
        return students;
    }

}
