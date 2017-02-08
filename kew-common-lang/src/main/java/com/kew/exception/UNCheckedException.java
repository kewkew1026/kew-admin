package com.kew.exception;

/**
 * Created by qiudanping on 2017/2/8.
 */
public class UNCheckedException extends RuntimeException{

    private static final long serialVersionUID = 1720755012635650684L;

    private String code;

    public String getOutMsg(){
        ExceptionCode mcode = ExceptionCode.getByCode(code);
        if(mcode!=null){
            return mcode.getDesout();
        }
        return getMessage();
    }

    public String getInMsg(){
        ExceptionCode mcode = ExceptionCode.getByCode(code);
        if(mcode!=null){
            return mcode.getDesin();
        }
        return getMessage();
    }

    public UNCheckedException() {
        super();
    }

    public UNCheckedException(Throwable e) {
        super(e);
    }

    public UNCheckedException(String errorCode) {
        super();
        this.code = errorCode;
    }

    public UNCheckedException(ExceptionCode mcode, Throwable e) {
        super(mcode.getDesin(),e);
        this.code = mcode.getCode();
    }

    public UNCheckedException(String code, Throwable e) {
        super(ExceptionCode.getInMsg(code),e);
        this.code = code;
    }

    public UNCheckedException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UNCheckedException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
