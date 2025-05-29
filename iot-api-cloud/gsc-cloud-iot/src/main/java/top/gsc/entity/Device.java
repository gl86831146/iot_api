package top.gsc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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

    /**
     * 设备唯一标识(如MAC地址)
     */
    private String deviceId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备类型 1-对 2-温度传感器 3-控制器
     */
    private Integer type;

    /**
     * 状态：0-离线 1-在线
     */
    private Integer status;

    /**
     * 温度
     */
    private Float temperature;

    /**
     * 湿度
     */
    private Float humidity;

    /**
     * 设备功能类型: temp_control-温控系统, security-安防系统
     */
    private String deviceType;

    /**
     * 场景参数配置
     */
    
    private String sceneParams;

    /**
     * 最后触发时间
     */
    private LocalDateTime lastTriggerTime;

    /**
     * 归属用户ID
     */
    private Long tenantId;

    /**
     * 当前已绑定用户数
     */
    private Integer bindUserCount;

    /**
     * 是否激活 (0-未激活 1-激活)
     */
    private Integer isActivated;

    /**
     * 绑定状态 (0-未绑定 1-已绑定)
     */
    private Integer bindStatus;
}
