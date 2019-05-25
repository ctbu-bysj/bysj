package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "firstDraft")
public class FirstDraft {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  String firstDraftId;
    /**
     * 论文地址
     */
    private  String  paperPath;
    /**
     * 代码地址
     */
    private  String codePath;
    /**
     * 截图地址
     */
    private  String imagePath;
    /**
     * 视频地址
     */
    private String  vidoPath;
    /**
     * 其他资料
     */
    private String  otherMaterial;
    /**
     * 作品部署信息
     */
    private  String  workDeployment;
    private  String  DevelopmentTechnology;//开发技术
    private  String  DatabaseTechnology;//数据库技术
    /**
     * 成果形式
     */
    private  String   resultsForm;

}
