package com.ctbu.schoolofai.btsjmanager.basicInformation.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.BasicInformation;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BasicInformationDao extends JpaRepository<BasicInformation,String> {
    /**
     * 通过工作阶段是否创建查询
     * @param b
     * @return
     */
    BasicInformation findByCollegePro(boolean b);

}
