package com.fenjin.cloud.configbeans;


import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡工具
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

    /**
     * 配置负载均衡算法
     * @return
     */
    @Bean
    public IRule myRule(){

        // 轮训算法（默认）
//        return new RoundRobinRule();

        // 随机算法
//        return new RandomRule();

        // 可用轮训算法（过滤掉访问故障处于断路器跳闸状态及并发连接数超过阈值的服务）
//        return new AvailabilityFilteringRule();

        // 相应时间权重算法（根据平均相应时间计算权重，刚启动时采用轮训算法）
//        return new WeightedResponseTimeRule();

        // 重试轮训算法（获取服务失败后在指定时间内重新获取）
        return new RetryRule();

        // 最佳可用算法（先过滤掉多次访问故障而处于断路器跳闸状态的服务，然后选择并发量最小的服务器）
//        return new BestAvailableRule();

        // 区域性能可用算法（复合判断service所在区域的性能和可用性服务器）
//        return new ZoneAvoidanceRule();
    }
}
