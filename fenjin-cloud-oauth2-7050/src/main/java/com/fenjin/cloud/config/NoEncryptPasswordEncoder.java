package com.fenjin.cloud.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @version 1.0
 * @ClassName: NoEncryptPasswordEncoder
 * @Descriprion: TODO(用一句话描述这个类的作用)
 * @author: changzhengmao
 * @date: 2019-03-05 09:19
 */
public class NoEncryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals((String) charSequence);
    }
}
