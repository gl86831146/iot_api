package top.gsc.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.gsc.dto.MobileLoginDTO;
import top.gsc.dto.UserDTO;
import top.gsc.entity.UserEntity;
import top.gsc.framework.security.user.UserDetail;
import top.gsc.vo.UserVO;
/**
 * @author mqxu
 **/
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    UserVO convert(UserEntity entity);
    UserEntity convert(UserDTO dto);
    UserVO convert(UserDetail userDetail);
    UserEntity convert(MobileLoginDTO dto);
    UserDetail convertDetail(UserEntity entity);
}
