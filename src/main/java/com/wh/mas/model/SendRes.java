package com.wh.mas.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

@Data
public class SendRes {

    private String msgGroup;
    private String rspcod;
    private Boolean success;
}
