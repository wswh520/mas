package com.wh.mas.dao;

import com.wh.mas.base.MasMapper;
import com.wh.mas.model.SysMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface SysMessageMapper extends MasMapper<SysMessage> {

    public Integer saveSysMessage(SysMessage sysMessage);
}
