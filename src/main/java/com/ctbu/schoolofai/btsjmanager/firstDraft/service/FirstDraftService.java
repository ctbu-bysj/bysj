package com.ctbu.schoolofai.btsjmanager.firstDraft.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.FirstDraft;

public interface FirstDraftService {
    /**
     * 初稿提交
     * @param firstDraft
     * @return
     */
   FirstDraft save(FirstDraft firstDraft);

    /**
     * 通过id查找
     * @param id
     * @return
     */
   FirstDraft findById(long id);
}
