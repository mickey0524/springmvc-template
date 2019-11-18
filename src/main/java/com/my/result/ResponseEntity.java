package com.my.result;

import java.io.Serializable;
import static com.my.common.ResponseCode.OK;

public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 5974837894415816475L;

    private Integer code;
    private String msg;
    private T data;

    public ResponseEntity() {
        this.code = OK.getCode();
        this.msg = OK.getMsg();
    }

    public static ResponseEntity ok() {
        ResponseEntity entity = new ResponseEntity();
        return entity;
    }

    public static <T> ResponseEntity<T> successWithData(T data) {
        ResponseEntity entity = new ResponseEntity();
        entity.setData(data);
        return entity;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
