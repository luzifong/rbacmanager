package com.rbacmanager.permission.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rbacmanager.permission.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final String secretKey = "a991c041-ae87-446e-bc8b-2d7c179620d2";

    public static String generateToken(User user, Integer expiresDays) {
        Map<String, Object> headerMap = new HashMap<String, Object>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");
        Date start = new Date();
        /** 24 * 60*/
        long currentTime = System.currentTimeMillis() + expiresDays * 60 * 1000;//?天
        Date end = new Date(currentTime);
        String token = JWT.create()
                .withHeader(headerMap)
                .withIssuer("yushu")
                .withIssuedAt(start)
                .withExpiresAt(end)
                .withClaim("userId", user.getUser_id())
                .withClaim("uid", user.getUid())
                .withClaim("userName", user.getUsername())
                .sign(Algorithm.HMAC256(secretKey));
        return token;
    }

    public static boolean checkTokenExpires(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
