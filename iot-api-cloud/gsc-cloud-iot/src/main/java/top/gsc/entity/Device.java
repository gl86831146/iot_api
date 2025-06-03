package top.gsc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.gsc.framework.mybatis.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author mqxu
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device")
public class Device extends BaseEntity {
    @TableId
    private Long id;

    @TableField("device_id")
    private String deviceId;

    @TableField("name")
    private String name;

    @TableField("type")
    private String type;

    @TableField("status")
    private Integer status;

    @TableField("temperature")
    private Float temperature;

    @TableField("humidity")
    private Float humidity;

    @TableField("deleted")
    private Integer deleted;

    @TableField("device_type")
    private Integer deviceType;


    @TableField("last_trigger_time")
    private LocalDateTime lastTriggerTime;

    @TableField("tenant_id")
    private Long tenantId;

    @TableField("bind_user_count")
    private Integer bindUserCount;

    @TableField("is_activated")
    private Integer isActivated;

    @TableField("bind_status")
    private Integer bindStatus;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
