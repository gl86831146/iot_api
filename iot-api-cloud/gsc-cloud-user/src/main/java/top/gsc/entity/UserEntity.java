package top.gsc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import top.gsc.framework.mybatis.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author mqxu
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String mobile;
    private String nickname;
    private String avatar;
    private String email;
    private Integer gender;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;
}