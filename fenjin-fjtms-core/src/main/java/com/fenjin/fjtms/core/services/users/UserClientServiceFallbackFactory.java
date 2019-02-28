package com.fenjin.fjtms.core.services.users;

import com.fenjin.fjtms.core.domain.users.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过FallbackFactory实现对IUserClientService所有方法的降级处理，
 * 达到对UserController注解@HystrixCommand达到服务熔断的解耦，避免代码膨胀
 */
@Component
public class UserClientServiceFallbackFactory implements FallbackFactory<IUserClientService> {

    @Override
    public IUserClientService create(Throwable throwable) {
        return new IUserClientService(){

            @Override
            public void create(User user) {

            }

            @Override
            public void delete(String id) {

            }

            @Override
            public void edit(User user) {

            }

            @Override
            public List<User> list() {

                List<User> users = new ArrayList<User>();
                User user = new User();
                user.setId("没有对应的信息，该服务已暂停！");
                users.add(user);
                return users;
            }

            @Override
            public User get(String id) {
                User user = new User();
                user.setId("该ID：" + id + "没有对应的信息，该服务已暂停！");
                return user;
            }

            @Override
            public Object discovery() {
                return "没有对应的微服务信息，该服务已暂停！";
            }
        };
    }
}
