package com.rongzi.assistant.common.util;

import com.alibaba.fastjson.JSON;
import com.rongzi.assistant.common.constant.JwtConstants;
import com.rongzi.assistant.model.UserInfo;
import io.jsonwebtoken.Claims;

import java.util.Map;

public class JwtTokenUtilTest {

    public static void main(String[] args) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccountName("liuchao");
        userInfo.setEmpCode("AA1161");
        userInfo.setCityCode("SHANGHAI");

        String jwtToken = JwtTokenUtil.generateToken(userInfo, userInfo.getEmpCode());
        System.out.println(jwtToken);

        Claims claims = JwtTokenUtil.getClaimFromToken(jwtToken);
        Map<String, Object> map = (Map<String, Object>) claims.get(JwtConstants.CLAIMS_DATA_KEY);

        UserInfo result = (UserInfo) ReflectUtil.mapToObject(map, UserInfo.class);
        System.out.println(JSON.toJSON(result));
    }

}
