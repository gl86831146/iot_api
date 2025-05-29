package top.gsc.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.gsc.dto.DeviceDTO;
import top.gsc.entity.Device;
import top.gsc.vo.DeviceVO;
import java.util.List;
/**
 * 设备表
 *
 * @author moqi
 */
@Mapper
public interface DeviceConvert {
    DeviceConvert INSTANCE = Mappers.getMapper(DeviceConvert.class);
    Device convert(DeviceDTO deviceDto);
    DeviceVO convert(Device device);
    List<DeviceVO> convertList(List<Device> list);
}
