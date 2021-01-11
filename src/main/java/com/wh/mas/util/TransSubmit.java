/**
 * 具体的开发请以平台情况和接口文档为准
 * 
 *汇付天下有限公司
 *
 * Copyright (c) 2006-2013 ChinaPnR,Inc.All Rights Reserved.
 */
package com.wh.mas.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@Slf4j
public class TransSubmit {

    public static String doPost(String url, String param, String orderType) throws Exception {
        PrintWriter out = null;
        String result = "";
        DataInputStream dis=null;
//		logger.debug("url=" + url + ";orderType=" + orderType + ";param=" + param);
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.addRequestProperty("orderType", orderType);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            //conn.setRequestProperty("contentType", "UTF-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
//			out = new PrintWriter(conn.getOutputStream());
//			// 发送请求参数
//			out.print(param);
//			// flush输出流的缓冲
//			out.flush();
            OutputStream os =  conn.getOutputStream();
            os.write(param.getBytes("UTF-8"));
            os.flush();
            // 定义BufferedReader输入流来读取URL的响应
            byte[] bs = new byte[0];
            byte[] btemp = new byte[1024];
            int count =0;
            dis = new DataInputStream(conn.getInputStream());
            while((count = dis.read(btemp))>-1) {
                byte[] temp = bs;
                bs=new byte[temp.length+count];
                System.arraycopy(temp, 0, bs, 0, temp.length);
                System.arraycopy(btemp, 0, bs, temp.length, count);
            }
            result = new String(bs, "UTF-8");
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
