package com.fenjin.cloud.task;

import com.fenjin.fjtms.core.Result;
import com.fenjin.fjtms.core.query.AuthQuery;
import com.fenjin.fjtms.core.services.auths.IAuthClientService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @version 1.0
 * @ClassName: TokenScheduledTask
 * @Descriprion: TODO(定时刷新token)
 * @author: changzhengmao
 * @date: 2019-03-12 23:23
 */
public class TokenScheduledTask {

    private static Logger logger = LoggerFactory.getLogger(TokenScheduledTask.class);

    // 刷新频率
    public final static long REFRESH_FREQUENCY = 60 * 1000 * 60 * 20;

    @Autowired
    private IAuthClientService authClientService;

    /**
     * 刷新Token
     */
    @Scheduled(fixedDelay = REFRESH_FREQUENCY)
    public void reloadApiToken() {
        String token = this.getToken();
        while (StringUtils.isBlank(token)) {
            try {
                Thread.sleep(1000);
                token = this.getToken();
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
        System.setProperty("fenjin.auth.token", token);
    }

    public String getToken() {
        AuthQuery query = new AuthQuery();
        query.setAccessKey("android");
        query.setSecretKey("android");
        Result response = authClientService.auth(query);
        return response.getData() == null ? "" : response.getData().toString();
    }
}
