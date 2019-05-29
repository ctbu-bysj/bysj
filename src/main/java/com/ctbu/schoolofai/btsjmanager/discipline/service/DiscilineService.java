package com.ctbu.schoolofai.btsjmanager.discipline.service;

import com.ctbu.schoolofai.btsjmanager.discipline.dao.DiscilineDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscilineService {
    @Autowired
    private DiscilineDao discilineDao;

    /**
     * 查找所有
     * @return
     */
     public  List<Discipline>  findAll(){
        return discilineDao.findAll();
     }

    /**
     *添加学科
     * @param discipline
     * @return
     */
     public  Discipline save(Discipline discipline){

         return  discilineDao.save(discipline);
     }
}
