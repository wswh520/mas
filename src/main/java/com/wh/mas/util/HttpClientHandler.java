package com.wh.mas.util;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.tomcat.util.security.MD5Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientHandler {

    /**
     * MAP类型数组转换成NameValuePair类型
     * 
     */
    public static List<NameValuePair> buildNameValuePair(Map<String, String> params) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        return nvps;
    }
    
}
