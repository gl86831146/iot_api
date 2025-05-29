package top.gsc.dao;

import org.apache.ibatis.annotations.Mapper;
import top.gsc.entity.Device;
import top.gsc.framework.mybatis.dao.BaseDao;
import java.util.List;
import java.util.Map;
/**
 * @author moqi
 */
@Mapper
public interface DeviceDao extends BaseDao<Device> {
    List<Device> getList(Map<String, Object> params);
}
