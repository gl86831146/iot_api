package top.gsc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.gsc.framework.mybatis.entity.BaseEntity;
/**
 * @author mqxu
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device")
public class Device extends BaseEntity {
    private String deviceId;
    private String name;
    private Integer type;
    private Boolean status;
    private Float temperature;
    private Float humidity;
}
