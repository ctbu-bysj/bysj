package com.ctbu.schoolofai.btsjmanager.basicInformation.service;

import com.ctbu.schoolofai.btsjmanager.basicInformation.dao.BasicInformationDao;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.BasicInformation;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicInformationServiceImpl implements BasicInformationService {

    @Autowired
    private BasicInformationDao basicInformationDao;
    @Override
    public BasicInformation saveBasicIn(BasicInformation basicInformation) {
        return basicInformationDao.save(basicInformation);
    }

    @Override
    public BasicInformation findByCollege(boolean b) {
        return basicInformationDao.findByCollegePro(false);
    }
}
