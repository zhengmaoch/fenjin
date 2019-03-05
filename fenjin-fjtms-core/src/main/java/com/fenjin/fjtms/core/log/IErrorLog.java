package com.fenjin.fjtms.core.log;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@FeignClient(value = "FJ_CLOUD_LOG_SERVICE", fallbackFactory = ErrorLogFallbackFactory.class)
public interface IErrorLog {
    @PostMapping("/ServiceErrorLog")
    Map create(Map errorLog);
}
