package com.ctbu.schoolofai.btsjmanager.secondPaperFinalize.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.PaperFinalize;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.SecondPaperFinalize;
import com.ctbu.schoolofai.btsjmanager.secondPaperFinalize.dao.SecondPaperFinalizeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondPaperFinalizeService {
  @Autowired
    private SecondPaperFinalizeDao secondPaperFinalizeDao;

    /**
     * 保存二次答辩论文定稿
     * @param
     * @return
     */
  public SecondPaperFinalize savePaperFinalize(SecondPaperFinalize secondpaperFinalize){
      return secondPaperFinalizeDao.save(secondpaperFinalize);
  }

    /**
     * 通过id查找
     * @param id
     * @return
     */
  public  SecondPaperFinalize findById(String id){
      return  secondPaperFinalizeDao.getOne(id);
  }

}
