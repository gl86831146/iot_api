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
    private Integer type;  // 1-灯 2-遥感传感器 3-数码器 4-红外传感器

    @TableField("status")
    private Integer status;  // 0-离线 1-在线

    @TableField("temperature")
    private Float temperature;

    @TableField("humidity")
    private Float humidity;

    @TableField("deleted")
    private Integer deleted;  // 0-正常 1-已删除

    @TableField("device_type")
    private String deviceType;  // temp_control/security

    @TableField("scene_params")
    private String sceneParams;  // JSON格式数据

    @TableField("last_trigger_time")
    private LocalDateTime lastTriggerTime;

    @TableField("tenant_id")
    private Long tenantId;

    @TableField("bind_user_count")
    private Integer bindUserCount;

    @TableField("is_activated")
    private Integer isActivated;  // 0-未激活 1-激活

    @TableField("bind_status")
    private Integer bindStatus;  // 0-未绑定 1-已绑定

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
