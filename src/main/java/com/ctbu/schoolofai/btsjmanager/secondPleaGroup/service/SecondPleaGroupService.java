package com.ctbu.schoolofai.btsjmanager.secondPleaGroup.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.SecondPleaGroup;
import com.ctbu.schoolofai.btsjmanager.secondPleaGroup.dao.SecondPleaGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondPleaGroupService {
    @Autowired
    private SecondPleaGroupDao secondPleaGroupDao;

     public SecondPleaGroup findById(long id){
         return  secondPleaGroupDao.getOne(id);

     }

     public  SecondPleaGroup save(SecondPleaGroup secondPleaGroup){

         return  secondPleaGroupDao.save(secondPleaGroup);
     }

}
