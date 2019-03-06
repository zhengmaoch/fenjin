package com.fenjin.fjtms.core;

import java.util.List;

public class BaseController {

    public Result Result(Object object){

        return object == null ? new Result().failed() : new Result().success(object);
    }

    public Result Result(boolean b){

        return b ?  new Result().success(b) : new Result().failed();
    }

    public Result Result(List data){

        return data == null ? new Result().failed() : new Result().success(data);
    }

    public Result Result(int pageIndex, int pageSize, int total, List data){

        return data == null ? new Result().failed() : new Result().pageSuccess(pageIndex, pageSize, total, data);
    }
}
