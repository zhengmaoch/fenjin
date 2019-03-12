package com.fenjin.fjtms.core.query;

/**
 * @version 1.0
 * @ClassName: AuthQuery
 * @Descriprion: TODO(API用户认证参数类)
 * @author: changzhengmao
 * @date: 2019-03-12 22:53
 */
public class AuthQuery {
    private String accessKey;
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
