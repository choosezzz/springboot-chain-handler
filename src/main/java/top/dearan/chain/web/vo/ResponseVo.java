package top.dearan.chain.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 14:44
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

    private int code;
    private String msg;
    private T data;


    public ResponseVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
