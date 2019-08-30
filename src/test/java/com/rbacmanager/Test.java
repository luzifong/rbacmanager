package com.rbacmanager;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rbacmanager.permission.mapper.TokenMapper;
import com.rbacmanager.permission.mapper.UserMapper;
import com.rbacmanager.permission.pojo.User;
import com.rbacmanager.permission.pojo.UserToken;
import com.rbacmanager.permission.util.TokenUtil;
import com.sun.corba.se.spi.ior.ObjectKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    UserMapper userMapper;



    @org.junit.Test
    public void test() throws UnsupportedEncodingException, ParseException {
//        String str = "{\n" +
//                " \"iss\": \"ninghao.net\",\n" +
//                " \"exp\": \"1438955445\",\n" +
//                " \"name\": \"wanghao\",\n" +
//                " \"admin\": true\n" +
//                "}";
//        String encode = Base64.getEncoder().encodeToString(str.getBytes());
//        System.out.println(encode);


//        System.out.println(UUID.randomUUID().toString().substring(0, 5));
//        System.out.println(UUID.randomUUID().toString().substring(0, 5));
//        System.out.println(UUID.randomUUID().toString().substring(0, 5));




        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 2 * 60 * 1000;//? 分钟
        Date end = new Date(currentTime);
//        String token1 = "";
//        String token2 = "";
//        token1 = JWT.create().withAudience("mike").withIssuedAt(start).withExpiresAt(end)
//                .sign(Algorithm.HMAC256("password"));
//
//        token2 = JWT.create().withAudience("mike").withIssuedAt(start).withExpiresAt(end)
//                .sign(Algorithm.HMAC256("password"));
//        System.out.println(token1);
//        System.out.println(token2);




//      eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmciOiJ0ZW5jZW50IiwibmFtZSI6Im1pa2UiLCJleHAiOjE1NjY4MTIxODMsImlhdCI6MTU2NjgxMjEyMywiYWdlIjoiMTgifQ.VNnVlOCJzfl5Pl95RRslFaobyx_Dk5DbhgBaEbZkhpI
        String uuid1 = "a991c041-ae87-446e-bc8b-2d7c179620d2";
        String uuid2 = "eba6f910-cc80-418f-b112-dfee76a7231b";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("alg", "HS256");
//        map.put("typ", "JWT");
//        String token3 = JWT.create()
//                .withHeader(map)
//                .withClaim("name", "mike")
//                .withClaim("age", "18")
//                .withClaim("org", "tencent")
//                .withIssuedAt(start)
//                .withExpiresAt(end)
//                .sign(Algorithm.HMAC256(uuid1));
//        System.out.println(token3);
       String token3 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjQsImlzcyI6Inl1c2h1IiwiZXhwIjoxNTY3MTM2MDUyLCJ1c2VyTmFtZSI6IueUqOaItzQiLCJpYXQiOjE1NjcxMzU4NzIsInVzZXJJZCI6MTl9.4ZDISw7fAxAwMkXiBQpZMcq1NvUWNYChEBPnqPWSe2I";

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(uuid1)).build();
        try {
            DecodedJWT decodedJWT = verifier.verify(token3);
            Map<String, Claim> claims = decodedJWT.getClaims();
            long expires = decodedJWT.getExpiresAt().getTime() - decodedJWT.getIssuedAt().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("过期时间：" + sdf.format(decodedJWT.getExpiresAt()));
            System.out.println("有效期 " + (expires / 1000 / 60) + " 分钟");
            System.out.println("userId=" + claims.get("userId").asInt());
            System.out.println("uid=" + claims.get("uid").asInt());
            System.out.println("userName=" + claims.get("userName").asString());
        } catch (Exception e) {
            System.out.println("token超时了");
        }

//        DecodedJWT decodedJWT2 = verifier.verify(token3);

//        byte[] bytes = Base64.getUrlDecoder().decode("eyJpYXQiOjE1NjY4ODg2NzQsImV4cCI6MTU2Njg4ODY4NCwic3ViIjoiMTk5MzAzMTEiLCJpc3MiOiJodWFuIiwidXNlcl9pZCI6ImFkbWluIiwicGhvbmUiOiIxODI1MTQyMTAwMCIsImFnZSI6MjUsInNleCI6IueUtyJ9");
//        System.out.println(new String(bytes, "UTF-8"));




//        String SECRET_KEY = "SECRET_KEY";
//        String jwtToken = Jwts.builder()
//                // jwt 标注中的申明
//                .setIssuedAt(new Date()) // 签发时间
//                .setExpiration(new Date(new Date().getTime() + 10000L))// 过期时间
//                .setSubject("19930311")// jwt面向的客户
//                .setIssuer("huan")// jwt的签发者
//                // 公共申明和私有申明
//                .claim("user_id", "admin")
//                .claim("phone", "18251421000")
//                .claim("age", 25)
//                .claim("sex", "男")
//
//                // 签证
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
//                .compact();
//        System.out.println(jwtToken);

//        List<User> users = tokenMapper.listUser();
//        System.out.println(users.toString());
//        User user = new User();
//        user.setUser_id(4);
//        user.setUid(122);
//        user.setUsername("超级管理员");
//        String token = TokenUtil.generateToken(user, 3);
//        System.out.println(token);
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowTime = sdf.format(date);
//        Date time = sdf.parse(nowTime);
//        System.out.println(time);
//        userMapper.updateTokenInfoByUserId(user.getUser_id(), "clean", new java.sql.Date(date.getTime()));
    }
}
