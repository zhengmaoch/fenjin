package com.fenjin.fjtms.core.config;

import com.fenjin.fjtms.core.common.RibbonFilterContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.Map;

/**
 * @version 1.0
 * @ClassName: FeignBasicAuthRequestInterceptor
 * @Descriprion: TODO(Feign请求拦截器)
 * @author: changzhengmao
 * @date: 2019-03-12 22:25
 */
public class FeignBasicAuthRequestInterceptor  implements RequestInterceptor {

    public FeignBasicAuthRequestInterceptor() {

    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", System.getProperty("fenjin.auth.token"));
        Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
        for (String key :  attributes.keySet()) {
            String value = attributes.get(key);
            System.out.println("feign :" + key + "\t" + value);
            template.header(key, value);
        }
    }
}