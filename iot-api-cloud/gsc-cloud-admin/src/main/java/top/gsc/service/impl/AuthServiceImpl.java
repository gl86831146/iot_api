package top.gsc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import top.gsc.framework.common.exception.ServerException;
import top.gsc.framework.security.cache.TokenStoreCache;
import top.gsc.framework.security.user.ManagerDetail;
import top.gsc.framework.security.user.UserDetail;
import top.gsc.framework.security.utils.JwtUtil;
import top.gsc.framework.security.utils.TokenUtils;
import top.gsc.model.dto.AccountLoginDTO;
import top.gsc.model.entity.SysManager;
import top.gsc.model.vo.AccountLoginVO;
import top.gsc.service.AuthService;


/**
 * @author mqxu
 **/
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final TokenStoreCache tokenStoreCache;

    @Override
    public AccountLoginVO loginByAccount(AccountLoginDTO login) {
        Authentication authentication;
        try {
            // ⽤户认证
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("⽤户名或密码错误");
        }
        // ⽤户信息
        ManagerDetail user = (ManagerDetail) authentication.getPrincipal();
        // ⽣成 accessToken
        String accessToken = JwtUtil.createToken(user.getId());
        // 保存⽤户信息到缓存
        tokenStoreCache.saveManager(accessToken, user);
        AccountLoginVO accountLoginVO = new AccountLoginVO();
        accountLoginVO.setId(user.getId());
        accountLoginVO.setAccessToken(accessToken);
        accountLoginVO.setUsername(user.getUsername());
        return accountLoginVO;
    }


    @Override
    public void logout(String accessToken) {
        // 删除⽤户信息
        tokenStoreCache.deleteUser(accessToken);
    }
}