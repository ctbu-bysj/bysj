package com.ctbu.schoolofai.btsjmanager.database.service;

import com.ctbu.schoolofai.btsjmanager.database.dao.DatabaseDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
       @Autowired
       private DatabaseDao databaseDao;

    /**
     * 查找所有
     * @return
     */
    public List<Database> findAll(){

           return  databaseDao.findAll();
       }

    /**
     * 保存
     * @param database
     * @return
     */
       public  Database save(Database database){

        return databaseDao.save(database);
       }
}
