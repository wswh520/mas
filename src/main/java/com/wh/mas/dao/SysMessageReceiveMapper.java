package com.wh.mas.dao;

import com.wh.mas.base.MasMapper;
import com.wh.mas.model.SysMessageReceive;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMessageReceiveMapper extends MasMapper<SysMessageReceive> {

    public Integer saveSysMessageReceive(SysMessageReceive sysMessageReceive);
}
