package com.wh.mas.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wh.mas.model.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    public static Result getResult(String jsonData) {
        Result result = null;
        // 响应成功，例：
        //{"msgGroup":"0927152506001000833076","rspcod":"success","success":true}
        //响应失败，例：
        //{ "msgGroup": "", "rspcod": "InvalidUsrOrPwd", "success": false}
        try {
            JSONObject jsonObject = JSONObject.parseObject(jsonData);
            String msgGroup = jsonObject.getString("msgGroup");
            String rspcod = jsonObject.getString("rspcod");
            if(StringUtils.isNotBlank(msgGroup) &&StringUtils.isNotBlank(rspcod)){
                result = new Result();
                Boolean success = jsonObject.getBoolean("success");
                result.setMsgGroup(msgGroup);
                result.setRspcod(rspcod);
                result.setSuccess(success);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "{\"msgGroup\":\"\",\"rspcod\":\"InvalidUsrOrPwd\",\"success\":false}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
    }
}
