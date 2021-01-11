package com.wh.mas.service;

import com.wh.mas.dao.SysMessageLogMapper;
import com.wh.mas.model.SysMessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMessageLogService{

    @Autowired
    private SysMessageLogMapper sysMessageLogMapper;

    public Integer insertSysMessageLog(String type,String content){
        SysMessageLog sysMessageLog = new SysMessageLog();
        sysMessageLog.setType(type);
        sysMessageLog.setContent(content);
        return sysMessageLogMapper.insertSysMessageLog(sysMessageLog);
    }
}
