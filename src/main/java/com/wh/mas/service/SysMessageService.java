package com.wh.mas.service;

import com.wh.mas.dao.SysMessageMapper;
import com.wh.mas.model.SysMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMessageService {

    @Autowired
    private SysMessageMapper sysMessageMapper;

    public void insertSysMessage(SysMessage model){
        // 保存发送信息
        sysMessageMapper.insert(model);
    }
}
