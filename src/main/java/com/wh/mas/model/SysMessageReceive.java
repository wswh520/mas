package com.wh.mas.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysMessageReceive {

    private String content;  //` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '回复内容',
    private Date receiveTime;//` date NOT NULL COMMENT '接收时间',
    private String telephone;//` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '发送人',
    private String exNumber; //` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '拓展码，用户下行短信关联'
}
