package top.gsc.service;

import top.gsc.dto.UserDTO;
import top.gsc.entity.UserEntity;
import top.gsc.framework.mybatis.service.BaseService;
import top.gsc.vo.UserVO;
/**
 * @author mqxu
 **/
public interface UserService extends BaseService<UserEntity> {
    void save(UserDTO vo);
    void update(UserDTO dto);
    UserVO getByMobile(String mobile);
    UserVO getById(Long id);
}