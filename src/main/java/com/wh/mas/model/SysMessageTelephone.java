package com.wh.mas.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysMessageTelephone {

    private String telephone;//` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号码',
    private Date messageid;  //` date NOT NULL COMMENT 'Message表主键id',
    private Integer result;  //` int(11) DEFAULT NULL COMMENT '发送状态：0未提交，1提交成功，2提交失败，3发送成功，4发送失败',
    private String errormsg; //` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发送返回结果信息'
}
