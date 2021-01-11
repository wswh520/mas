package com.wh.mas.model;

/**
 * 短信回调Bean
 */
public class MsgCallbackBean {

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 短信内容
     */
    private String smsContent;

    /**
     * 短信发送时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String sendTime;

    /**
     * 上行服务代码
     */
    private String addSerial;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getAddSerial() {
        return addSerial;
    }

    public void setAddSerial(String addSerial) {
        this.addSerial = addSerial;
    }

    @Override
    public String toString() {
        return "MsgCallbackBean{" +
                "mobile='" + mobile + '\'' +
                ", smsContent='" + smsContent + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", addSerial='" + addSerial + '\'' +
                '}';
    }
}
