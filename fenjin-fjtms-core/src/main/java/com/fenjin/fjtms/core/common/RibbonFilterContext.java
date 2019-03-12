package com.fenjin.fjtms.core.common;

import java.util.Map;

/**
 * @version 1.0
 * @ClassName: RibbonFilterContext
 * @Descriprion: TODO(用一句话描述这个接口的作用)
 * @author: changzhengmao
 * @date: 2019-03-12 22:30
 */
public interface RibbonFilterContext {
    RibbonFilterContext add(String key, String value);

    String get(String key);

    RibbonFilterContext remove(String key);

    Map<String, String> getAttributes();
}
