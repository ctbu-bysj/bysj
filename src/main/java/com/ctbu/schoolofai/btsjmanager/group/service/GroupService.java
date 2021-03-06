package com.ctbu.schoolofai.btsjmanager.group.service;

import com.ctbu.schoolofai.btsjmanager.group.dao.GroupDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupDao groupDao;

    public Group findById(long id){
        groupDao.getOne(id);
        return  groupDao.getOne(id);
    }

    /**
     * 添加小组
     * @param group
     * @return
     */
   public  Group save(Group group){
        return groupDao.save(group);
   }
}
