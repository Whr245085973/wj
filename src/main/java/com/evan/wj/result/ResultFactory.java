package com.evan.wj.result;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/10/18 15:15
 **/
public class ResultFactory {
    /*创建成功返回数据*/
    public static Result buildSuccessResult(Object data){
        return buildResult(ResultCode.SUCCESS,"成功",data);
    }
    /*创建失败返回信息*/
    public static Result buildFailResult(String message){
        return buildResult(ResultCode.FAIL,message,null);
    }
    /*利用枚举进行重载*/
    public static Result buildResult(ResultCode resultCode, String message, Object data){
        return buildResult(resultCode.code, message, data);
    }
    /*创建Result对象*/
    public static Result buildResult(int resultCode,String message,Object data){
        return new Result(resultCode,message,data);
    }
}
