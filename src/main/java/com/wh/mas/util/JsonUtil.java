package com.wh.mas.util;

import com.alibaba.fastjson.JSONObject;
import com.wh.mas.model.SendRes;
import org.apache.commons.lang3.StringUtils;

public class JsonUtil {

    public static SendRes getResult(String jsonData) {
        SendRes sendRes = null;
        // 响应成功，例：
        //{"msgGroup":"0927152506001000833076","rspcod":"success","success":true}
        //响应失败，例：
        //{ "msgGroup": "", "rspcod": "InvalidUsrOrPwd", "success": false}
        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            String msgGroup = jsonObject.getString("msgGroup");
            String rspcod = jsonObject.getString("rspcod");
            if(StringUtils.isNotBlank(msgGroup) &&StringUtils.isNotBlank(rspcod)){
                sendRes = new SendRes();
                Boolean success = jsonObject.getBoolean("success");
                sendRes.setMsgGroup(msgGroup);
                sendRes.setRspcod(rspcod);
                sendRes.setSuccess(success);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendRes;
    }

    public static void main(String[] args) {
        String str = "{\"msgGroup\":\"\",\"rspcod\":\"InvalidUsrOrPwd\",\"success\":false}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
    }
}
