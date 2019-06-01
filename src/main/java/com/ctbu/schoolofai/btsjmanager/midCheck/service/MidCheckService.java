package com.ctbu.schoolofai.btsjmanager.midCheck.service;


import com.ctbu.schoolofai.btsjmanager.midCheck.dao.MidCheckDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.MidCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.sql.Types.NULL;

@Service
public class MidCheckService {

    @Autowired
    private MidCheckDao midCheckDao;

    /**
     * 提交中期检查
     * @return
     */
    public MidCheck midCheckSave(MidCheck midCheck){
         MidCheck midCheckNew= midCheckDao.save(midCheck);
          if(midCheck.getMidCheckId()!=NULL)
                 return midCheckNew;
          else return null;
    }

    public  MidCheck findMidCheck(long id){
       return midCheckDao.getOne(id);
    }
}
