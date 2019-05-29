package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @PlayName
 * @Author guoqiang
 * @Description //TODO
 * @Date 2019-05-08 14:46
 * @Param
 * @return
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /*
     * @PlayName getUser
     * @Author guoqiang
     * @Description //TODO 通过ID主键获取user对象
     * @Date 2019-05-08 14:44
     * @Param [id]
     * @return cn.itcast.user.pojo.User
     **/
    public User getUser(String id) throws InterruptedException {
        if(id.equals("2")){
            throw new RuntimeException("抛出异常");
        }
        User user=userMapper.selectByPrimaryKey(id);
        Thread.sleep(2000);
        return user;
    }

}
