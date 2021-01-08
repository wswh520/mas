package com.wh.mas.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

@Data
public class Result {

    private String msgGroup;
    private String rspcod;
    private Boolean success;
}
