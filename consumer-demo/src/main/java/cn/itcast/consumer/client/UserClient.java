package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName UserClient
 * @Description TODO
 * @Author guoqiang
 * @Date 2019-05-29 15:23
 * @Version 1.0
 **/
@FeignClient(value = "user-service", fallback = UserClientFallBack.class )
public interface UserClient {


    @RequestMapping("getUser")
    User queryById(@RequestParam("id") String id);
}
