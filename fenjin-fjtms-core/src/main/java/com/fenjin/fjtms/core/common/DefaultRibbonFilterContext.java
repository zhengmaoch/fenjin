package com.fenjin.fjtms.core.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName: DefaultRibbonFilterContext
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-12 22:31
 */
public class DefaultRibbonFilterContext implements RibbonFilterContext {
    private final Map<String, String> attributes = new HashMap<String, String>();

    @Override
    public RibbonFilterContext add(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    @Override
    public String get(String key) {
        return attributes.get(key);
    }

    @Override
    public RibbonFilterContext remove(String key) {
        attributes.remove(key);
        return this;
    }

    @Override
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }
}
