package com.wh.mas.model;

/**
 * MAS消息状态接受bean
 *
 * @author 小道仙
 * @date 2020/10/11
 */
public class MasStatusBean {

    /**
     * 发送成功状态码：DELIVRD
     */
    private String reportStatus;

    /**
     * 回执手机号，每批次返回一个号码
     */
    private String mobile;

    /**
     * 提交时间，格式：yyyyMMddHHmmss
     */
    private String submitDate;

    /**
     * 接收时间 格式：yyyyMMddHHmmss
     */
    private String receiveDate;

    /**
     * 发送失败的状态码，如DB:0140
     */
    private String errorCode;

    /**
     * 消息批次号，唯一编码，与发送响应中的msgGroup对应
     */
    private String msgGroup;


    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(String msgGroup) {
        this.msgGroup = msgGroup;
    }

    @Override
    public String toString() {
        return "MasStatusBean{" +
                "reportStatus='" + reportStatus + '\'' +
                ", mobile='" + mobile + '\'' +
                ", submitDate='" + submitDate + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", msgGroup='" + msgGroup + '\'' +
                '}';
    }
}

