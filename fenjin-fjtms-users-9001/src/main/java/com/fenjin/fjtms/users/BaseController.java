package com.fenjin.fjtms.users;

import com.fenjin.fjtms.core.Result;

import java.util.List;

public class BaseController {


    public Result commonResult(Object object){

        Result result;
        if(object != null){
            result = new Result().success(object);
        }
        else {
            result = new Result().failed();
        }
        return result;
    }

    public Result commonResult(boolean b){

        Result result;
        if(b){
            result = new Result().success(b);
        }
        else {
            result = new Result().failed();
        }
        return result;
    }

    public Result commonResult(int pageIndex, int pageSize, int total, List data){

        Result result;
        if(data != null){
            result = new Result().pageSuccess(pageIndex, pageSize, total, data);
        }
        else {
            result = new Result().failed();
        }
        return result;
    }
}
