package com.wh.mas.dao;

import com.wh.mas.base.MasMapper;
import com.wh.mas.model.SysMessageTelephone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMessageTelephoneMapper extends MasMapper<SysMessageTelephone> {

    public void saveSysMessageTelephone(String telephone,Integer result,Integer messageid,String errormsg);

    public SysMessageTelephone findSysMessageTelephoneByErrormsg(String errormsg);

}
