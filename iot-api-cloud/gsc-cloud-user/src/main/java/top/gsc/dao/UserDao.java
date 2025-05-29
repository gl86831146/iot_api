package top.gsc.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.gsc.entity.UserEntity;
import top.gsc.framework.mybatis.dao.BaseDao;
/**
 * @author moqi
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    default UserEntity getById(Long id) {
        return this.selectOne(new QueryWrapper<UserEntity>().eq("id", id))
                ;
    }
    default UserEntity getByUsername(String username) {
        return this.selectOne(new QueryWrapper<UserEntity>().eq("username"
                , username));
    }
    default UserEntity getByMobile(String mobile) {
        return this.selectOne(new QueryWrapper<UserEntity>().eq("mobile",
                mobile));
    }
}