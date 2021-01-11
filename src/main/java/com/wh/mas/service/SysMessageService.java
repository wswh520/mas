package com.wh.mas.service;

import com.wh.mas.dao.SysMessageMapper;
import com.wh.mas.model.SysMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SysMessageService {

    @Autowired
    private SysMessageMapper sysMessageMapper;

    public Integer insertSysMessage(String content,String username,String exnumber){
        SysMessage mode = new SysMessage();
        mode.setContent(content);
        mode.setUsername(username);
        mode.setExnumber(exnumber);
        // 保存发送信息
        sysMessageMapper.saveSysMessage(mode);
        Integer id = mode.getId();
        log.info("SysMessageId:{}",id);
        return id;
    }

}
