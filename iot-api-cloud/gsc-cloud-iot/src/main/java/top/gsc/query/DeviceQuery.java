package top.gsc.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.gsc.framework.common.query.Query;
/**
 *@author mqxu
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "设备查询")
public class DeviceQuery extends Query {
    @Schema(description = "设备类型")
    private Integer deviceType;
    @Schema(description = "设备名称")
    private String name;
    @Schema(description = "设备状态")
    private Boolean status;
}
