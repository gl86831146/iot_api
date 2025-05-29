package top.gsc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.gsc.framework.security.mobile.MobileVerifyCodeService;
import top.gsc.sms.service.AliyunSmsService;


/**
 * 短信验证码效验
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final AliyunSmsService smsService;
    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsService.verifyCode(mobile, code);
    }
}
