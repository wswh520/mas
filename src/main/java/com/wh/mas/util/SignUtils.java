///**
// * 说明： 配置信息仅供Demo使用，开发请根据实际情况配置
// *
// *汇付天下有限公司
// *
// * Copyright (c) 2006-2013 ChinaPnR,Inc.All Rights Reserved.
// */
//package com.wh.mas.util;
//
//import java.io.Serializable;
//import java.io.UnsupportedEncodingException;
//import java.security.KeyFactory;
//import java.security.PrivateKey;
//import java.security.Signature;
//import java.security.spec.PKCS8EncodedKeySpec;
//
//import org.apache.log4j.Logger;
//
////import chinapnr.Base64;
////import chinapnr.SecureLink;
//
//public class SignUtils implements Serializable {
//	private static final Logger LOGGER = Logger.getLogger(SignUtils.class);
//    private static final long  serialVersionUID        = 3640874934537168392L;
//
//    /** RSA验证签名成功结果 **/
//    public static final int    RAS_VERIFY_SIGN_SUCCESS = 0;
//
////    /** 商户公钥 (UFX)**/
////    public static final String UFX_PUBLIC_KEY = PropertiesUtil.getValue("ufx_public_key");
////
////    /** 商户私钥  (UFX)**/
////    public static final String UFX_PRIVATE_KEY = PropertiesUtil.getValue("ufx_private_key");
//
//    /** 商户客户号(汇付) **/
//    public static final String RECV_MER_ID = "531052";
//
//	/** 商户公钥(汇付) **/
//    public static final String MER_PUB_KEY_PATH = "D:/app/PgPubk.key";;
//
//    /** 商户私钥 (汇付)**/
//    public static final String MER_PRI_KEY_PATH = "D:/app/MerPrK531052.key";
//
//
//    /**
//     * 汇付
//     * RSA方式加签
//     * @param custId
//     * @param forEncryptionStr
//     * @param charset
//     * @return
//     * @throws Exception
//     */
//    public static String encryptByRSA(String forEncryptionStr) throws Exception {
//        SecureLink sl = new SecureLink();
//        int result = sl.SignMsg(RECV_MER_ID, MER_PRI_KEY_PATH, forEncryptionStr);
//        if (result < 0) {
//            // 打印日志
//            throw new Exception();
//        }
//        return sl.getChkValue();
//    }
//
//    /**
//     * 汇付
//     * 验证签名
//     * @param forEncryptionStr
//     * @param chkValue
//     * @return
//     * @throws Exception
//     */
//    public static boolean verifyByRSA(String forEncryptionStr, String chkValue) throws Exception {
//        try {
//            int verifySignResult = new SecureLink().VeriSignMsg(MER_PUB_KEY_PATH, forEncryptionStr, chkValue);
//            return verifySignResult == RAS_VERIFY_SIGN_SUCCESS;
//        } catch (Exception e) {
//            // 打印日志
//            throw new Exception();
//        }
//    }
//    /**
//     * UFX
//	 * 生成签名的方法,必须为utf-8格式
//	 * @param str  签名明文字符串
//	 * @param privateKey  私钥
//	 * @return
//	 */
//	public static String subsign(String str,String privateKey){
//		LOGGER.debug("签名明文："+str);
//		LOGGER.debug("签名私钥："+privateKey);
//		String signature = null;
//		try {
//			byte[] prikeybytes = RSAUtil.hexString2ByteArr(privateKey);
//			// 构造PKCS8EncodedKeySpec对象
//			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(prikeybytes);
//			// 指定的加密算法
//			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//			// 取私钥匙对象
//			PrivateKey privatekey = keyFactory.generatePrivate(pkcs8KeySpec);
//			Signature instance = Signature.getInstance("SHA1withRSA");
//			instance.initSign(privatekey);
//			byte[] digest = str.getBytes("UTF-8");
//			instance.update(digest);
//			byte[] sign = instance.sign();
//			signature = RSAUtil.byteArr2HexString(sign);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		LOGGER.debug("签名参数sign："+signature);
//		return signature;
//	}
//
//	/**
//	 * UFX
//	 * 校验签名参数,必须为utf-8格式
//	 * @param str  签名明文
//	 * @param sign  签名参数
//	 * @param pubKey 公钥
//	 * @return 返回true和false，true代表验签通过，false代表验签失败
//	 */
//	public static boolean checkSign(String str,String sign,String pubKey){
//		LOGGER.debug("验签明文："+str);
//		LOGGER.debug("签名参数sign："+sign);
//		LOGGER.debug("签名公钥："+pubKey);
//
//		boolean flag = false;
//		try {
//			Signature instance = Signature.getInstance("SHA1withRSA");//用指定算法产生签名对象
//			instance.initVerify(RSAUtil.generatePublicKeyFromDer(pubKey));//使用公钥初始化签名对象,用于验证签名
//			byte[] digest = str.getBytes("UTF-8");
//			instance.update(digest); //更新签名内容
//			flag = instance.verify(RSAUtil.hexString2ByteArr(sign));//得到验证结果
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//	/**
//	 * 中文Base64转码
//	 * @param str
//	 * @return
//	 */
//	public static String getBase64Encode(String str) {
//        if (str == null || "".equals(str)) {
//            return "";
//        }
//        try {
//            byte[] bt = str.getBytes("UTF-8");
//            str = String.valueOf(Base64.encode(bt));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return str;
//    }
//	/**
//	 * 中文Base64解码
//	 * @param str
//	 * @return
//	 */
//	public static String getBase64Decode(String str) {
//        if (str == null || "".equals(str)) {
//            return "";
//        }
//        char[] ch = str.toCharArray();
//        byte[] bt = Base64.decode(ch);
//        try {
//            str = new String(bt,"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return str;
//    }
//}
