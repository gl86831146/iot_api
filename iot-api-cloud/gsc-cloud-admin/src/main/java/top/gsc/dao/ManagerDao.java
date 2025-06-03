package top.gsc.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.gsc.model.entity.SysManager;

import java.util.List;

@Mapper
public interface ManagerDao extends BaseMapper<SysManager> {

    /**
     * 根据ID查询管理员
     */
    default SysManager getById(Long id) {
        return this.selectOne(new QueryWrapper<SysManager>()
                .eq("id", id));
    }

    /**
     * 根据用户名查询管理员
     */
    default SysManager getByUsername(String username) {
        return this.selectOne(new QueryWrapper<SysManager>()
                .eq("username", username));
    }

    /**
     * 根据角色类型查询管理员列表
     */
    default List<SysManager> getByRoleType(Integer roleType) {
        return this.selectList(new QueryWrapper<SysManager>()
                .eq("role_type", roleType));
    }

    /**
     * 根据状态查询管理员列表
     */
    default List<SysManager> getByStatus(Integer status) {
        return this.selectList(new QueryWrapper<SysManager>()
                .eq("status", status));
    }
}
