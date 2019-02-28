package com.fenjin.fjtms.users;

import com.fenjin.fjtms.core.CommonResult;

import java.util.List;

public class BaseController {


    public CommonResult commonResult(Object object){

        CommonResult commonResult;
        if(object != null){
            commonResult = new CommonResult().success(object);
        }
        else {
            commonResult = new CommonResult().failed();
        }
        return commonResult;
    }

    public CommonResult commonResult(boolean b){

        CommonResult commonResult;
        if(b){
            commonResult = new CommonResult().success(b);
        }
        else {
            commonResult = new CommonResult().failed();
        }
        return commonResult;
    }

    public CommonResult commonResult(int pageIndex, int pageSize, int total, List data){

        CommonResult commonResult;
        if(data != null){
            commonResult = new CommonResult().pageSuccess(pageIndex, pageSize, total, data);
        }
        else {
            commonResult = new CommonResult().failed();
        }
        return commonResult;
    }
}
