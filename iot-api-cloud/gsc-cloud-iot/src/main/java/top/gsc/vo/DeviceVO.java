package top.gsc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.gsc.framework.common.utils.DateUtils;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * @author mqxu
 **/
@Data
@Schema(description = "设备VO")
public class DeviceVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "设备唯一标识")
    private String deviceId;

    @Schema(description = "设备名称")
    private String name;

    @Schema(description = "设备类型")
    private Integer type;

    @Schema(description = "设备状态")
    private Integer status;

    @Schema(description = "温度")
    private Float temperature;

    @Schema(description = "湿度")
    private Float humidity;

    @Schema(description = "设备功能类型")
    private String deviceType;

    @Schema(description = "场景参数配置（JSON格式）")
    private String sceneParams;

    @Schema(description = "最后触发时间")
    private LocalDateTime lastTriggerTime;

    @Schema(description = "租户ID")
    private Long tenantId;

    @Schema(description = "当前已绑定用户数")
    private Integer bindUserCount;

    @Schema(description = "是否激活：0-未激活 1-激活")
    private Integer isActivated;

    @Schema(description = "绑定状态：0-未绑定 1-已绑定")
    private Integer bindStatus;


    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
