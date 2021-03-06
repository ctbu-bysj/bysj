package com.ctbu.schoolofai.btsjmanager.publicTable.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "college_progress")
public class CollegeProgress
{
    /**
     * 主键  阶段id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long  id;

    /**
     * 阶段名称
     */
    @Column(name = "name")
    private String  name;

    /**
     * 阶段开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 阶段结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 状态 值为： 未开始  正在进行中  已经结束
     */
    @Column(name = "status")
    private String status;
    /**
     *阶段描述
     */

    private String describe;
    /**
     * 毕业设计工作基本信息
     */
    @ManyToOne
    @JoinColumn(name = "basicInformation_id")
    private  BasicInformation basicInformation;
}