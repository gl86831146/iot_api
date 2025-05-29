package top.gsc.service;

import top.gsc.dto.MobileLoginDTO;
import top.gsc.dto.AccountLoginDTO;
import top.gsc.vo.AccountLoginVO;
import top.gsc.vo.MobileLoginVO;
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
     * ⼿机短信登录
     *
     * @param login 登录信息
     */
    MobileLoginVO loginByMobile(MobileLoginDTO login);
    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}
