package com.fenjin.cloud.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName: RequestParameterWrapper
 * @Descriprion: TODO(request请求中添加参数)
 * @author: changzhengmao
 * @date: 2019-03-15 14:18
 */
//public class RequestParameterWrapper extends HttpServletRequestWrapper {
//
//    private Map<String, String[]> params = new HashMap<String, String[]>();
//
//    public RequestParameterWrapper(HttpServletRequest request) {
//        super(request);
//        //将现有parameter传递给params
//        this.params.putAll(request.getParameterMap());
//    }
//
//    /**
//     * 重载构造函数
//     * @param request
//     * @param extraParams
//     */
//    public RequestParameterWrapper(HttpServletRequest request, Map<String, Object> extraParams) {
//        this(request);
//        addParameters(extraParams);
//    }
//
//    public void addParameters(Map<String, Object> extraParams) {
//        for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
//            addParameter(entry.getKey(), entry.getValue());
//        }
//    }
//
//    /**
//     * 重写getParameter，代表参数从当前类中的map获取
//     * @param name
//     * @return
//     */
//    @Override
//    public String getParameter(String name) {
//        String[]values = params.get(name);
//        if(values == null || values.length == 0) {
//            return null;
//        }
//        return values[0];
//    }
//
//    /**
//     * 同上
//     * @param name
//     * @return
//     */
//    @Override
//    public String[] getParameterValues(String name) {
//        return params.get(name);
//    }
//
//    /**
//     * 添加参数
//     * @param name
//     * @param value
//     */
//    public void addParameter(String name, Object value) {
//        if (value != null) {
//            System.out.println(value);
//            if (value instanceof String[]) {
//                params.put(name, (String[]) value);
//            } else if (value instanceof String) {
//                params.put(name, new String[]{(String) value});
//            } else {
//                params.put(name, new String[]{String.valueOf(value)});
//            }
//        }
//    }
//}
