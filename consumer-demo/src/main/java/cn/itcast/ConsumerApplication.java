package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * @PlayName
 * @Author guoqiang
 * @Description //TODO
 * @Date 2019-05-13 22:42
 * @Param
 * @return
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    /**
     * @PlayName main
     * @Author guoqiang
     * @Description //TODO
     * @Date 2019-05-13 22:42
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}