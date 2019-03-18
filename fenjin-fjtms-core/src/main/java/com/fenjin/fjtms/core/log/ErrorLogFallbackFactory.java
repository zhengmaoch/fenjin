package com.fenjin.fjtms.core.log;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorLogFallbackFactory implements FallbackFactory<IErrorLog> {

    @Override
    public IErrorLog create(Throwable throwable) {
        return new IErrorLog() {
            @Override
            @SuppressWarnings("unchecked")
            public Map create(Map errorLog) {
                errorLog =new HashMap();
                errorLog.put("status","404");
                errorLog.put("data","没有连接成功！");
                return errorLog;
            }
        };
    }
}
