package com.wh.mas.dao;

import com.wh.mas.model.SysMessageLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMessageLogMapper {

    public Integer insertSysMessageLog(SysMessageLog sysMessageLog);
}
