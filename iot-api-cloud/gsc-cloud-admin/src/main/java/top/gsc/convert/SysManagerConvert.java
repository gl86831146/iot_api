package top.gsc.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.gsc.framework.security.user.ManagerDetail;
import top.gsc.model.entity.SysManager;

@Mapper
public interface SysManagerConvert {
    SysManagerConvert INSTANCE = Mappers.getMapper(SysManagerConvert.class);
    ManagerDetail convertDetail(SysManager entity);
}
