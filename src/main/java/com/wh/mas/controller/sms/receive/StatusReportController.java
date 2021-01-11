package com.wh.mas.controller.sms.receive;

import com.alibaba.fastjson.JSON;
import com.wh.mas.model.MasStatusBean;
import com.wh.mas.model.MsgCallbackBean;
import com.wh.mas.model.SendRes;
import com.wh.mas.model.SysMessageTelephone;
import com.wh.mas.service.SysMessageLogService;
import com.wh.mas.service.SysMessageReceiveService;
import com.wh.mas.service.SysMessageService;
import com.wh.mas.service.SysMessageTelephoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/sms")
@Slf4j
public class StatusReportController extends HttpServlet {

    @Autowired
    private SysMessageLogService sysMessageLogService;
    @Autowired
    private SysMessageReceiveService sysMessageReceiveService;

    /**
     * 状态报告
     */
    @RequestMapping(value = "statusReport",produces="text/html;charset=UTF-8;")
        public void statusReport(@RequestBody MasStatusBean masStatusBean) throws Exception {
        log.info("接收到短信报告");
        log.info(masStatusBean.toString());
        // 保存日志信息
        sysMessageLogService.insertSysMessageLog("发送普通短信异步反馈",masStatusBean.toString());
    }

    /**
     * 上行短信
     * MsgCallbackBean{mobile='15705692776', smsContent='d', sendTime='2021-01-11 15:58:36', addSerial='106575297722'}
     */
    @RequestMapping(value = "visitCallback",produces="text/html;charset=UTF-8;")
    public void visitCallback(@RequestBody MsgCallbackBean msgCallbackBean) {
        log.info("接收到上行短信");
        log.info(msgCallbackBean.toString());
        //存入数据库
        sysMessageReceiveService.saveSysMessageReceive(msgCallbackBean);
        // 保存日志信息
        sysMessageLogService.insertSysMessageLog("上行短信异步反馈",msgCallbackBean.toString());
    }
}