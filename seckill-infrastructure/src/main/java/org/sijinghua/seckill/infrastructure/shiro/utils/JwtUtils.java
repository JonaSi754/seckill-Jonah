package org.sijinghua.seckill.infrastructure.shiro.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.sijinghua.seckill.domain.constants.SeckillConstants;

import java.util.Date;

/**
 * @Date: 2023/6/4
 * @Author: Jonah Si
 * @Description: JWT工具类
 */
public class JwtUtils {
    /**
     * 验证token是否正确
     * @param token  口令
     * @param secret 密钥
     * @return  是否正确
     */
    public static boolean verify(String token, String secret) {
        try {
            // 根据密钥生成JWT验证器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                .withClaim(SeckillConstants.TOKEN_CLAIM, getUserId(token))
                .build();
            // 校验token
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    /**
     * 无需secret解密也能得到token中的信息
     * @param token 口令
     * @return userId
     */
    public static Long getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(SeckillConstants.TOKEN_CLAIM).asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 制作token
     * @param userId 用户ID
     * @param secret 密钥
     * @return 加密的token
     */
    public static String sign(Long userId, String secret) {
        Date date = new Date(System.currentTimeMillis() + SeckillConstants.TOKEN_EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
            .withClaim(SeckillConstants.TOKEN_CLAIM, userId)
            .withExpiresAt(date)
            .sign(algorithm);
    }

    /**
     * 制作token
     * @param userId 用户ID
     * @return 加密的token
     */
    public static String sign(Long userId) {
        return sign(userId, SeckillConstants.JWT_SECRET);
    }
}
