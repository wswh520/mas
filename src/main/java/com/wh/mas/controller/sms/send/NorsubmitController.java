package com.wh.mas.controller.sms.send;

import com.wh.mas.dao.SysMessageMapper;
import com.wh.mas.util.MD5Util;
import com.wh.mas.util.TransSubmit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * 发送普通短信
 */
@RestController
@RequestMapping("/sms")
public class NorsubmitController extends HttpServlet {

    @Autowired
    private SysMessageMapper sysMessageMapper;

    private static String sign = "wHwvfNuH5";//签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取。
    private static String secretKey = "hdkjdx";//用户密码
    private static String ecName = "东华工程科技股份有限公司";//企业名称
    private static String apId = "hdkjdx";//接口账号用户名

    @RequestMapping(value = "norsubmit",produces="text/html;charset=UTF-8;")
    public void doDeal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //收信手机号码。英文逗号分隔，每批次限5000个号码，例：“13800138000,13800138001,13800138002”。
        String mobiles = request.getParameter("mobiles");
        String content = request.getParameter("content");//短信内容
        if(StringUtils.isNotBlank(mobiles) && StringUtils.isNotBlank(content)) {
            TransSubmit ts = new TransSubmit();
            Map<String, String> params = getParams(mobiles,content);
//        // 1. result 为同步返回的结果(jason格式)，可转换成对应的实体对象
//        // 2. 注意：此返回结果中没有使用encode，所以不需要做decode处理
//        // 3. 验证签名的方式与异步应答的验签相同，可参照异步应答接收的处理方式
            String result = ts.doPost(params,"http://112.35.1.155:1992/sms/norsubmit");
            System.out.println(result);
            System.out.println("回调结果result================="+result);
            response.getWriter().print(result);
        }else{
            response.getWriter().print("手机号码或短信内容为空");
        }
    }


    /**
     * 模拟放款接口请求参数
     * @throws Exception
     *
     */
    private Map<String, String> getParams(String mobiles,String content){

        //扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位。
        String addSerial = "";
        //参数校验序列，生成方法：将ecName、apId、secretKey、mobiles、content、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算得出值。
        String mac = MD5Util.getMD5Encode(ecName+apId+secretKey+mobiles+content+sign+addSerial);

        //        ecName	String	企业名称。
//        apId	String	接口账号用户名。
//        mobiles	String	收信手机号码。英文逗号分隔，每批次限5000个号码，例：“13800138000,13800138001,13800138002”。
//        content	String	短信内容。
//        sign	String	签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取。
//        addSerial	String	扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位。
//        mac	String	参数校验序列，生成方法：将ecName、apId、secretKey、mobiles、content、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算得出值。


        Map<String, String> params = new HashMap<String, String>();
        params.put("ecName", ecName);//企业名称
        params.put("apId", apId);//接口账号用户名
        params.put("mobiles", mobiles);//收信手机号码。英文逗号分隔，每批次限5000个号码，例：“13800138000,13800138001,13800138002”。
        params.put("content", content);//短信内容
        params.put("sign", sign);//签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取。
        params.put("addSerial", addSerial);//扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位。
        params.put("mac", mac);//参数校验序列，生成方法：将ecName、apId、secretKey、mobiles、content、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算得出值。

        // 组装加签字符串原文
        // 注意加签字符串的组装顺序参 请照接口文档
        StringBuffer buffer = new StringBuffer();
        buffer.append(StringUtils.trimToEmpty(ecName)).append(StringUtils.trimToEmpty(apId))
            .append(StringUtils.trimToEmpty(mobiles)).append(StringUtils.trimToEmpty(content))
            .append(StringUtils.trimToEmpty(sign)).append(StringUtils.trimToEmpty(addSerial))
            .append(StringUtils.trimToEmpty(addSerial)).append(StringUtils.trimToEmpty(mac));
        String plainStr = buffer.toString();
        System.out.println(plainStr);

        return params;
    }

}
