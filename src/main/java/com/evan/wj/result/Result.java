package com.evan.wj.result;

/*该类是作用于返回前台页面信息处理*/
public class Result {
    private int code;
    private String message;
    private Object data;
    /*创建对象时传入数据*/
    public Result(int code,String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
