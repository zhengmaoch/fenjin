package com.fenjin.cloud.filter;

import com.fenjin.fjtms.core.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName: RequestFilter
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-15 14:23
 */
//@Component
//public class RequestFilter implements Filter {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        Map<String, Object> extraParams = new HashMap<String, Object>();
//
//        String grant_type = request.getHeader("grant_type");
//        if(!StringUtil.isEmpty(grant_type)) { extraParams.put("grant_type", grant_type); }
//
//        String username = request.getHeader("username");
//        if(!StringUtil.isEmpty(username)) { extraParams.put("username", username); }
//
//        String password = request.getHeader("password");
//        if(!StringUtil.isEmpty(password)) { extraParams.put("password", password); }
//
//        String token = request.getHeader("access_token");
//        if(!StringUtil.isEmpty(token)) { extraParams.put("access_token", request.getHeader("access_token")); }
//
//        //利用原始的request对象创建自己扩展的request对象并添加自定义参数
//        RequestParameterWrapper requestParameterWrapper = new RequestParameterWrapper(request);
//        requestParameterWrapper.addParameters(extraParams);
//        filterChain.doFilter(requestParameterWrapper, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
