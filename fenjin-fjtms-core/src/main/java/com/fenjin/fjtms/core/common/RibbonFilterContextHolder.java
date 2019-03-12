package com.fenjin.fjtms.core.common;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @version 1.0
 * @ClassName: RibbonFilterContextHolder
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-12 22:29
 */
/**
 * @author yinjihuan
 * @create 2017-11-16 13:51
 **/
public class RibbonFilterContextHolder {
    private static final TransmittableThreadLocal<RibbonFilterContext> contextHolder = new TransmittableThreadLocal<RibbonFilterContext>() {
        @Override
        protected RibbonFilterContext initialValue() {
            return new DefaultRibbonFilterContext();
        }
    };


    public static RibbonFilterContext getCurrentContext() {
        return contextHolder.get();
    }


    public static void clearCurrentContext() {
        contextHolder.remove();
    }
}
