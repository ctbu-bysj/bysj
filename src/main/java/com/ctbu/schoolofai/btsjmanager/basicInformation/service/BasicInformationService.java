package com.ctbu.schoolofai.btsjmanager.basicInformation.service;


import com.ctbu.schoolofai.btsjmanager.publicTable.domain.BasicInformation;

public interface BasicInformationService {
    /**
     * 保存毕业设计基本信息
     * @param basicInformation
     * @return
     */
  BasicInformation saveBasicIn(BasicInformation basicInformation);

    /**
     * 通过工作阶段是否创建查询
     * @param b
     * @return
     */
  BasicInformation findByCollege(boolean b);

}
