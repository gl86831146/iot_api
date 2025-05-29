package top.gsc.sms.service;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import top.gsc.framework.common.cache.RedisCache;
import top.gsc.framework.common.cache.RedisKeys;
import top.gsc.framework.common.exception.ErrorCode;
import top.gsc.framework.common.exception.ServerException;
import top.gsc.sms.config.RonglianyunSmsConfig;
import top.gsc.sms.utils.SmsUtils;

import java.util.HashMap;

/**
 * @author mqxu
 **/
@Slf4j
@Service
@AllArgsConstructor
public class RonglianyunSmsService extends SmsService {
    private final RonglianyunSmsConfig ronglianyunSmsConfig;
    private final RedisCache redisCache;
//    @Override
//    public boolean sendSms(String mobile) {
////         校验⼿机号合法性
//        if (!SmsUtils.checkPhone(mobile)) {
//            throw new ServerException(ErrorCode.PARAMS_ERROR);
//        }
//        // ⽣成随机验证码
//        String code = RandomStringUtils.randomNumeric(4);
//        // 验证码和过期时间（单位：分钟）
//        String[] params = {code, "1"};
//        String templateId = ronglianyunSmsConfig.getTemplateId();
//        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
//        sdk.init(ronglianyunSmsConfig.getServerIp(), ronglianyunSmsConfig.
//                getServerPort());
//        sdk.setAccount(ronglianyunSmsConfig.getAccountSId(), ronglianyunSmsConfig.getAccountToken());
//        sdk.setAppId(ronglianyunSmsConfig.getAppId());
//        log.info(" ============= 短信发送成功 ============= ");
//        HashMap<String, Object> result = sdk.sendTemplateSMS(mobile, templateId, params);
//        if ("000000".equals(result.get("statusCode"))) {
//            log.info(" ============= 短信发送成功 ============= ");
//            // redis缓存验证码
//            redisCache.set(RedisKeys.getCaptchaKey(mobile), code, 60);
//            return true;
//        } else {
//            return false;
//        }
//
//    }
@Override
public boolean sendSms(String mobile) {
    // 校验手机号合法性
    if (!SmsUtils.checkPhone(mobile)) {
        throw new ServerException(ErrorCode.PARAMS_ERROR);
    }
    // 生成随机验证码
    String code = RandomStringUtils.randomNumeric(4);
    // 验证码和过期时间（单位：分钟）
    String[] params = {code, "1"};
    log.info(" ============= 生成验证码成功 ============= ");
    log.info("验证码: {}, 手机号: {}", code, mobile);

    // redis缓存验证码
    redisCache.set(RedisKeys.getCaptchaKey(mobile), code, 60);
    log.info(" ============= 验证码已存储到Redis ============= ");
    return true;
}
}