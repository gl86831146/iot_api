package top.gsc.framework.security.utils;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;
import top.gsc.framework.common.utils.HttpContextUtils;

/**
 * Token 工具类
 *
 * @author mqxu
 */
public class TokenUtils {

    /**
     * 生成 AccessToken
     */
    public static String generator(Long id) {
        return UUID.fastUUID().toString(true);
    }

    /**
     * 获取 AccessToken
     */
    public static String getAccessToken() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        if (request == null) {
            return null;
        }

        return getAccessToken(request);
    }

    /**
     * 获取 AccessToken
     */
    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        if (StrUtil.isBlank(accessToken)) {
            accessToken = request.getParameter("access_token");
        }

        return accessToken;
    }
}

