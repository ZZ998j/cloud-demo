package cn.itcast.consumer.web;

import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
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
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;


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
    public User queryById(@RequestParam String id){
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance instance = instances.get(0);
//        String url="http://"+instance.getHost()+":"+instance.getPort()+"/getUser?id="+id;

//        ServiceInstance choose = ribbonLoadBalancerClient.choose("user-service");
//        String url="http://"+choose.getHost()+":"+choose.getPort()+"/getUser?id="+id;

//        System.out.printf(url);
        String url="http://getUser?id="+id;
        User user= restTemplate.getForObject(url,User.class);
        return user;
    }
}
