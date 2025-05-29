package top.gsc.service;

import top.gsc.entity.Device;
import top.gsc.framework.common.utils.PageResult;
import top.gsc.framework.mybatis.service.BaseService;
import top.gsc.query.DeviceQuery;
import top.gsc.vo.DeviceVO;
/**
 * @author mqxu
 **/
public interface DeviceService extends BaseService<Device> {
    PageResult<DeviceVO> page(DeviceQuery query);
    /**
     * 发送命令
     *
     * @param deviceId 设备id
     * @param command 命令
     */
    void sendCommand(String deviceId, String command);
}
