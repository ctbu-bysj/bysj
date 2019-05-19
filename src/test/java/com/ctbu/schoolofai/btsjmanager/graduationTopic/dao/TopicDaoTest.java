package com.ctbu.schoolofai.btsjmanager.graduationTopic.dao;

import com.ctbu.schoolofai.btsjmanager.graduationTopic.domain.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicDaoTest{
    @Resource
    private TopicDao topicDao;
    @Test
    public void findAllByState() {

        System.out.print(topicDao.findAllByState("1"));
    }
}