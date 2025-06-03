package top.gsc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.gsc.framework.common.exception.ErrorCode;
import top.gsc.framework.common.utils.Result;
import top.gsc.framework.security.utils.TokenUtils;
import top.gsc.model.dto.AccountLoginDTO;
import top.gsc.model.vo.AccountLoginVO;
import top.gsc.service.AuthService;
import top.gsc.sms.service.RonglianyunSmsService;

@RestController
@RequestMapping("admin/auth")
@Tag(name = "认证模块")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<AccountLoginVO> accountLogin(@RequestBody AccountLoginDTO login) {
        AccountLoginVO accountLoginVO = authService.loginByAccount(login);
        return Result.ok(accountLoginVO);
    }


    @PostMapping("logout")
    @Operation(summary = "退出")
    public Result<String> logout(HttpServletRequest request) {
        authService.logout(TokenUtils.getAccessToken(request));
        return Result.ok();
    }
}
