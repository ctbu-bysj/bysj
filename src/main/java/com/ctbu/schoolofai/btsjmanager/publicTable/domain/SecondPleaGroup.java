package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 二次答辩小组
 */
@Data
@Entity
@Table(name = "group")
public class SecondPleaGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private long groupId;
    /**
     * 小组名
     */
    private  String groupName;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private  Date endTime;
    /**
     * 答辩地点
     */
    private  String address;


}
