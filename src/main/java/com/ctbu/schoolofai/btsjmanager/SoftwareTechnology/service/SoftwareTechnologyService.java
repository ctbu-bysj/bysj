package com.ctbu.schoolofai.btsjmanager.SoftwareTechnology.service;

import com.ctbu.schoolofai.btsjmanager.SoftwareTechnology.dao.SoftwareTechnologyDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.SoftwareTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareTechnologyService {

    @Autowired
    private SoftwareTechnologyDao softwareTechnologyDao;

    /**
     * 查找所有
     * @return
     */
    public List<SoftwareTechnology> findAll(){
       return softwareTechnologyDao.findAll();
    }

    /**
     * 保存
     * @param softwareTechnology
     * @return
     */
    public  SoftwareTechnology save(SoftwareTechnology softwareTechnology){

        return  softwareTechnologyDao.save(softwareTechnology);
    }

}
