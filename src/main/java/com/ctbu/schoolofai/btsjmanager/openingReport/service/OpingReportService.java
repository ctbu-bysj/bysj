package com.ctbu.schoolofai.btsjmanager.openingReport.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.OpeingReport;

public interface OpingReportService {
    /**
     * 保存开题报告
     * @param opeingReport
     * @return
     */
    public  String save(OpeingReport opeingReport);
}
