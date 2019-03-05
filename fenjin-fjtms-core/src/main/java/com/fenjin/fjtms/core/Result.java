package com.fenjin.fjtms.core;

import com.fenjin.fjtms.core.utils.JsonUtil;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应实体
 */
@Accessors(chain = true)
@NoArgsConstructor
public class Result {
    //操作成功
    public static final int SUCCESS = 200;
    //操作失败
    public static final int FAILED = 500;
    //未认证
    public static final int UNAUTHORIZED = 401;
    //未激活
    public static final int  NOT_ACTIVED = 402;
    //未授权
    public static final int  FORBIDDEN = 403;
    //参数校验失败
    public static final int VALIDATE_FAILED = 404;
    //数据库错误
    public static final int  DB_ERROR = 501;
    //参数为空
    public static final int  PARAM_PARAMETER_IS_NULL = 502;


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

    /**
     * 返回分页成功数据
     */
    public Result pageSuccess(int pageIndex, int pageSize, int total, List data) {
//        PageInfo pageInfo = new PageInfo(data);
        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageSize);
//        result.put("totalPage", pageInfo.getPages());
        result.put("total", total);
        result.put("pageIndex", pageIndex);
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
     * 普通失败提示信息
     */
    public Result failed(String message) {
        this.code = FAILED;
        this.message = message;
        return this;
    }

    /**
     * 参数验证失败使用
     *
     * @param message 错误信息
     */
    public Result validateFailed(String message) {
        this.code = VALIDATE_FAILED;
        this.message = message;
        return this;
    }

    /**
     * 未登录时使用
     *
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
     *
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

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
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
