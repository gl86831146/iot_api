package top.gsc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.gsc.convert.UserConvert;
import top.gsc.dao.UserDao;
import top.gsc.entity.UserEntity;
import top.gsc.framework.security.mobile.MobileUserDetailsService;
import top.gsc.service.MyUserDetailsService;
/**
 * ⼿机验证码登录
 *
 * @author mqxu
 **/
@Service
@AllArgsConstructor
public class MobileUserDetailsServiceImpl implements MobileUserDetailsService {
    private final MyUserDetailsService myUserDetailsService;
    private final UserDao sysUserDao;
    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        UserEntity userEntity = sysUserDao.getByMobile(mobile);
        if (userEntity == null) {
            throw new UsernameNotFoundException("⼿机号或验证码错误");
        }
        return myUserDetailsService.getUserDetails(UserConvert.INSTANCE.convertDetail(userEntity));
    }
}
