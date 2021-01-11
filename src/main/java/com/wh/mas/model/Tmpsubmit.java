package com.wh.mas.model;

import lombok.Data;

@Data
public class Tmpsubmit {
    private String ecName;//	String	企业名称。
    private String apId;//	String	接口账号用户名。
    private String templateId;//	String	模板ID。在云MAS平台创建模板，路径：『短信』→『模板短信』→『模板管理』，创建后提交审核，审核通过将获得模板ID。
    private String mobiles;//	String	收信手机号码。英文逗号分隔，每批次限5000个号码，例：“13800138000,13800138001,13800138002”。
    private String params;//	String	模板变量。格式：[“param1”,“param2”]，无变量模板填[""]。
    private String sign;//	String	签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取。
    private String addSerial;//	String	扩展码。依据开户时申请的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位。
    private String mac;//	String	参数校验序列，生成方法：将ecName、apId、secretKey、templateId、mobiles、params、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算出的值。
    private String secretKey;
}
