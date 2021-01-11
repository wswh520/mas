package com.wh.mas.service;

import com.wh.mas.dao.SysMessageReceiveMapper;
import com.wh.mas.model.MsgCallbackBean;
import com.wh.mas.model.SysMessageReceive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SysMessageReceiveService {

    @Autowired
    private SysMessageReceiveMapper sysMessageReceiveMapper;

    public Integer saveSysMessageReceive(MsgCallbackBean msgCallbackBean){
        SysMessageReceive sysMessageReceive = new SysMessageReceive();
        // content, receiveTime, telephone,exNumber
        sysMessageReceive.setContent(msgCallbackBean.getSmsContent());
        sysMessageReceive.setReceiveTime(dateFormat(msgCallbackBean.getSendTime()));
        sysMessageReceive.setTelephone(msgCallbackBean.getMobile());
        sysMessageReceive.setExNumber(msgCallbackBean.getAddSerial());
        return sysMessageReceiveMapper.saveSysMessageReceive(sysMessageReceive);
    }
    public Date dateFormat(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            // 注意格式需要与上面一致，不然会出现异常
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
