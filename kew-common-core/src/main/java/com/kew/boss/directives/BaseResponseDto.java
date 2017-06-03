package com.kew.boss.directives;

import com.kew.boss.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * Created by qiudanping on 2017/5/31.
 */
public class BaseResponseDto<T> implements Serializable {

    private T content;

    private boolean success=true;

    private String errorCode;

    private String errorMsg;

    public BaseResponseDto( ) {
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
        if(isSuccess()){
            this.errorCode=null;
            setErrorMsg(null);
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ResultCodeEnum resultCode){
        if(resultCode==ResultCodeEnum.SUCCESS){
            setSuccess(true);
        }else{
            setSuccess(false);
            setErrorCode(resultCode.getCode());
            setErrorCode(resultCode.getDescription());
        }
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
}
