package com.fenjin.fjtms.core;

import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务器返回
 */
@Data
public class Result {
    //操作成功
    public static final int SUCCESS = 200;
    //未认证
    public static final int UNAUTHORIZED = 401;
    //未授权
    public static final int  FORBIDDEN = 403;
    //请求资源找不到
    public static final int NOT_FOUND = 404;
    //请求格式不正确
    public static final int NOT_ACCEPTABLE = 406;
    //参数校验失败
    public static final int VALIDATE_FAILED = 422;
    //操作失败
    public static final int FAILED = 500;


    private int code;
    private String message;
    private Object data;

    /**
     * 普通成功返回
     *
     * @param data 获取的数据
     */
    public Result success(Object data) {
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = data;
        return this;
    }

//    /**
//     * 成功返回List数据
//     *
//     * @param data 获取的数据
//     */
//    public Result success(Object data) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("list", data);
//        this.code = SUCCESS;
//        this.message = "操作成功";
//        this.data = data;
//        return this;
//    }

    /**
     * 返回分页成功数据
     */
    public Result pageSuccess(int total, Object data) {
//        PageInfo pageInfo = new PageInfo(data);
        Map<String, Object> result = new HashMap<>();
//        result.put("pageSize", pageSize);
//        result.put("totalPage", pageInfo.getPages());
        result.put("total", total);
//        result.put("pageIndex", pageIndex);
        result.put("list", data);
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = result;
        return this;
    }

    /**
     * 普通失败提示信息
     */
    public Result failed() {
        this.code = FAILED;
        this.message = "操作失败";
        return this;
    }

    /**
     * 请求资源找不到
     */
    public Result notFound() {
        this.code = NOT_FOUND;
        this.message = "请求资源不存在";
        return this;
    }

    /**
     * 请求格式不正确
     */
    public Result notAcceptable() {
        this.code = NOT_ACCEPTABLE;
        this.message = "请求格式不正确";
        return this;
    }

    /**
     * 自定义失败提示信息
     */
    public Result failed(String message) {
        this.code = FAILED;
        this.message = message;
        return this;
    }

    /**
     * 参数验证失败使用
     * @param message 错误信息
     */
    public Result validateFailed(String message) {
        this.code = VALIDATE_FAILED;
        this.message = message;
        return this;
    }

    /**
     * 未登录时使用
     * @param message 错误信息
     */
    public Result unauthorized(String message) {
        this.code = UNAUTHORIZED;
        this.message = "暂未登录或token已经过期";
        this.data = message;
        return this;
    }

    /**
     * 未授权时使用
     * @param message 错误信息
     */
    public Result forbidden(String message) {
        this.code = FORBIDDEN;
        this.message = "没有相关权限";
        this.data = message;
        return this;
    }

    /**
     * 参数验证失败使用
     * @param result 错误信息
     */
    public Result validateFailed(BindingResult result) {
        validateFailed(result.getFieldError().getDefaultMessage());
        return this;
    }
}
