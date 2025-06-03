package top.gsc.service;


import top.gsc.model.dto.AccountLoginDTO;
import top.gsc.model.vo.AccountLoginVO;

/**
 * @author mqxu
 **/
public interface AuthService {
    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    AccountLoginVO loginByAccount(AccountLoginDTO login);
    /**

     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}
