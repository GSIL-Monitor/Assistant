package com.rongzi.assistant.manager;

import com.rongzi.assistant.common.constant.JwtConstants;
import com.rongzi.assistant.common.util.JwtTokenUtil;
import com.rongzi.assistant.common.util.ReflectUtil;
import com.rongzi.assistant.model.UserInfo;
import io.jsonwebtoken.Claims;

import java.util.Map;

public class TokenManager {

    public static String generateToken(UserInfo userInfo) {
        String jwtToken = JwtTokenUtil.generateToken(userInfo, userInfo.getEmpCode());
        return "Bearer " + jwtToken;
    }

    public static UserInfo getUserInfoFromToken(String token) throws Exception {
        final String jwtToken = token.substring(7);
        Claims claims = JwtTokenUtil.getClaimFromToken(jwtToken);
        Map<String, Object> map = (Map<String, Object>) claims.get(JwtConstants.CLAIMS_DATA_KEY);

        UserInfo userInfo = (UserInfo) ReflectUtil.mapToObject(map, UserInfo.class);

        return userInfo;
    }
}
