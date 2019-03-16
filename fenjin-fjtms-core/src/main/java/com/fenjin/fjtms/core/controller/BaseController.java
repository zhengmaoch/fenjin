package com.fenjin.fjtms.core.controller;

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
}
