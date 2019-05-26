package com.ctbu.schoolofai.btsjmanager.firstDraft.service;

import com.ctbu.schoolofai.btsjmanager.firstDraft.dao.FirstDraftDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.FirstDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstDraftServiceImpl implements FirstDraftService {

    @Autowired
    FirstDraftDao firstDraftDao;
    @Override
    public FirstDraft save(FirstDraft firstDraft) {
        return  firstDraftDao.save(firstDraft);
    }

    @Override
    public FirstDraft findById(String id) {
        return firstDraftDao.getOne(id);
    }
}
