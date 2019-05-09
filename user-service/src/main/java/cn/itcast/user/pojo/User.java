package cn.itcast.user.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name="base_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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

    //备注
    @Transient
    private String note;
}
