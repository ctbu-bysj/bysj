package com.ctbu.schoolofai.btsjmanager.paperFinalize.service;

import com.ctbu.schoolofai.btsjmanager.paperFinalize.dao.PaperFinalizeDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.PaperFinalize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperFinalizeService {
  @Autowired
    private PaperFinalizeDao paperFinalizeDao;

    /**
     * 保存一次答辩论文定稿
     * @param paperFinalize
     * @return
     */
  public PaperFinalize savePaperFinalize(PaperFinalize paperFinalize){
      return paperFinalizeDao.save(paperFinalize);
  }

    /**
     * 通过id查找
     * @param id
     * @return
     */
  public  PaperFinalize findById(String id){
      return  paperFinalizeDao.getOne(id);
  }

}
