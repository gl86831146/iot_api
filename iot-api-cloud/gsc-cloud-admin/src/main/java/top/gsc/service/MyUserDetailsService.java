package top.gsc.service;

import org.springframework.security.core.userdetails.UserDetails;
import top.gsc.framework.security.user.ManagerDetail;
import top.gsc.framework.security.user.UserDetail;

/**
 * @author mqxu
 **/
public interface MyUserDetailsService {
    UserDetails getUserDetails(ManagerDetail userDetail);
}