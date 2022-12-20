package com.ran.final1.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class RanUtil {
    public static long hour = 1000*60*60;
    public static String secretKey = "Zwh020716";

    /**
     * 生成token
     */
    public static String jwtGenerate(Map<String,String> payloadMap, long time){
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256");
        for(Map.Entry<String,String> entry : payloadMap.entrySet()){
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        String resultString = jwtBuilder
                .setExpiration(new Date(System.currentTimeMillis()+time*hour))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        return resultString;
    }

    /**
     * 解析token
     */
    public static Claims parse(String token,String key){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(key).parseClaimsJws(token);
        return claimsJws.getBody();
    }

    /**
     * 验证token时效性
     */
    public static boolean isTokenValid(String token){
        return parse(token,secretKey).getExpiration().after(new Date(System.currentTimeMillis()));
    }
}

enum Access{
    ADMIN(1),USER(2);
    private int value;

    Access(int value) {
        this.value = value;
    }
}
