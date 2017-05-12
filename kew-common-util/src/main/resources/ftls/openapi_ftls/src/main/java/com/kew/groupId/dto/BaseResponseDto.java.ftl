package com.kew.${c.groupId}.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseResponseDTO<T> {
    /**
    * 结果代码：0失败 , 1成功
    */
    private String result;

    /**
    * 错误代码
    */
    private String errorCode;
    /**
    * 错误信息
    */
    private String errorMsg;

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ResultCodeEnum resultCode){
        this.errorCode = resultCode.getCode();
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static BaseResponseDTO getDefaultResDto(){
        BaseResponseDTO defaultResDto = new BaseResponseDTO();
        defaultResDto.setResult("0");
        defaultResDto.setErrorCode("9999");
        defaultResDto.setErrorMsg("系统维护中,请稍后再试!");
        return defaultResDto;
    }

        @Override
        public String toString() {
             return ToStringBuilder.reflectionToString(this);
        }
}
