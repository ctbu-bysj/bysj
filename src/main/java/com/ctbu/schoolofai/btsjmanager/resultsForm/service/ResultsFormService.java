package com.ctbu.schoolofai.btsjmanager.resultsForm.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.ResultsForm;
import com.ctbu.schoolofai.btsjmanager.resultsForm.dao.ResultsFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsFormService {
   @Autowired
    private ResultsFormDao resultsFormDao;

    /**
     * 查找所有
     * @return
     */
   public List<ResultsForm> findAll(){

       return  resultsFormDao .findAll();
   }

    /**
     * 保存
     * @param resultsForm
     * @return
     */
   public  ResultsForm save(ResultsForm resultsForm){

       return  resultsFormDao.save(resultsForm);
   }
}
