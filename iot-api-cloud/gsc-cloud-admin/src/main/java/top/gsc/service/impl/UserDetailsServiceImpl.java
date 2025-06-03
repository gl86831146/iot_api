package top.gsc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.gsc.convert.SysManagerConvert;
import top.gsc.dao.ManagerDao;
import top.gsc.framework.security.user.ManagerDetail;
import top.gsc.model.entity.SysManager;
import top.gsc.service.MyUserDetailsService;

/**
 * 账号登录
 *
 * @author moqi
 **/
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MyUserDetailsService myUserDetailsService;
    private final ManagerDao managerDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysManager manager = managerDao.getByUsername(username);
        if (manager == null) {
            throw new UsernameNotFoundException("⽤户名或密码错误");
        }
        return myUserDetailsService.getUserDetails(SysManagerConvert.INSTANCE.convertDetail(manager));
    }
}
