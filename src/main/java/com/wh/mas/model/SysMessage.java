package com.wh.mas.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysMessage {

    private Integer id;     //` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    private String content; //` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '短信内容',
    private Date sendtime;  //` date DEFAULT NULL COMMENT '发送时间',
    private String username;//` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发送人',
    private String exnumber;//` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '拓展码（限制三位数字），用户下行短信关联',
    private Integer yxj;    //` int(11) DEFAULT NULL,
}
