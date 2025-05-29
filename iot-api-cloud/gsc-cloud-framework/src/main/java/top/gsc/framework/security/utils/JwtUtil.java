package top.gsc.framework.security.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.gsc.framework.common.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: krislorem
 * @Package: top.zjp.framework.security.utils
 * @Project: zjp-cloud
 * @name: JwtUtil
 * @Date: 2025/4/27 15:52
 * @FileName: JwtUtil
 * @description:
 */
@Slf4j
public class JwtUtil {
    /**
     * 盐值很重要，不能泄漏，且每个项目都应该不一样，可以放到配置文件中
     */
    private static final String KEY = "share-app-api";

    public static String createToken(Long userId) {
        DateTime now = DateTime.now();
        // 超时时间
        DateTime expTime = now.offsetNew(DateField.HOUR, 48);
        Map<String, Object> payload = new HashMap<>();
        // 签发时间
        payload.put(RegisteredPayload.ISSUED_AT, now);
        // 过期时间
        payload.put(RegisteredPayload.EXPIRES_AT, expTime);
        // 生效时间
        payload.put(RegisteredPayload.NOT_BEFORE, now);
        // 自定义载荷
        payload.put(Constant.USER_ID, userId);
        String token = JWTUtil.createToken(payload, KEY.getBytes());
        log.info("生成 JWT token：{}", token);
        return token;
    }

    public static boolean validate(String token) {
        try {
            JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
            // validate包含了verify
            boolean validate = jwt.validate(0);
            log.info("JWT token 校验结果：{}", validate);
            return validate;
        } catch (Exception e) {
            log.error("JWT token 校验异常：{}", e.getMessage());
            return false;
        }
    }

    public static JSONObject getJSONObject(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
        JSONObject payloads = jwt.getPayloads();
        payloads.remove(RegisteredPayload.ISSUED_AT);
        payloads.remove(RegisteredPayload.EXPIRES_AT);
        payloads.remove(RegisteredPayload.NOT_BEFORE);
        log.info("根据 token 获取原始内容：{}", payloads);
        return payloads;
    }

    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        if (StringUtils.isBlank(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        return accessToken;
    }
}

