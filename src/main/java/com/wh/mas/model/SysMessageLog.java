package com.wh.mas.model;

import lombok.Data;

@Data
public class SysMessageLog {
    private String type;//` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
    private String content;//` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
}
