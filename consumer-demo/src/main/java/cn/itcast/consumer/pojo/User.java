package cn.itcast.consumer.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
 
     private static final long serialVersionUID = 1L;

     private String userId;
 
     private Integer deptId;
 
     private String userName;
 
     private String password;
 
     private String realName;
 
     private String phone;
 
     private String mobile;

     private String email;

     private Date createTime;

     private Integer userStatus;

     private String note;
     }