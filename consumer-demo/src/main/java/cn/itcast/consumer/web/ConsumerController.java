package cn.itcast.consumer.web;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author guoqiang
 * @Date 2019-05-08 15:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "queryByIdFallbackall")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;


//    @Autowired
//    private RibbonLoadBalancerClient ribbonLoadBalancerClient;l
//    @Autowired
//    private DiscoveryClient discoveryClient;

    /**
     * @PlayName queryById
     * @Author guoqiang
     * @Description //TODO
     * @Date 2019-05-13 22:43
     * @Param [id]
     * @return cn.itcast.consumer.pojo.User
     **/
    @RequestMapping("getbyid")
    @HystrixCommand(
//            fallbackMethod = "queryByIdFallback",
            commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")
    })
    public User queryById(@RequestParam String id){

//        String url="http://user-service/getUser?id="+id;
//        User user= restTemplate.getForObject(url,User.class);
        User user3=userClient.queryById(id);
//        try{
//            user3=userClient.queryById(id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return user3;
    }




    public String queryByIdFallback(String id){
        return "忙忙忙";
    }
    public User queryByIdFallbackall(){
        User user2=new User();
        user2.setUserId("444");
        return user2;
    }

}

//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//        String url="http://"+instance.getHost()+":"+instance.getPort()+"/getUser?id="+id;

//        ServiceInstance choose = ribbonLoadBalancerClient.choose("user-service");
//        String url="http://"+choose.getHost()+":"+choose.getPort()+"/getUser?id="+id;

//        System.out.printf(url);