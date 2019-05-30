package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserClientImpl
 * @Description TODO
 * @Author guoqiang
 * @Date 2019-05-30 17:04
 * @Version 1.0
 **/
@Component
public class UserClientFallBack implements UserClient {
    @Override
    public User queryById(String id) {
        User user=new User();
        user. setUserId("4");
        user.setRealName("ceshiweizhaodao!!!");
        return user ;
    }
}
