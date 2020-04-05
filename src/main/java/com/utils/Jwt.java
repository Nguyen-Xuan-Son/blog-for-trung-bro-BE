package com.utils;

import com.constants.Config;
import com.constants.Secret;
import com.domain.AdminDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Jwt implements Serializable {
    private static final long serialVersionUID = -2550185165626007481L;

    public String getUserId(String token){
        Map<String, Object> result = getTokenData(token);
        if(result.get(AdminDetail.ID) != null) {
            return result.get(AdminDetail.ID).toString();
        }
        return null;
    }

    public String getUsername(String token){
        Map<String, Object> result = getTokenData(token);
        if(result.get(AdminDetail.USERNAME) != null) {
            return result.get(AdminDetail.USERNAME).toString();
        }
        return null;
    }

    private Map<String, Object> getTokenData(String token) {
        Map<String, Object> result = new HashMap<>();
        Claims claims = getAllClaimsFromToken(token);
        result.put(AdminDetail.ID,claims.get(AdminDetail.ID));
        result.put(AdminDetail.USERNAME,claims.get(AdminDetail.USERNAME));
        return result;
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(Secret.TOKEN_SECRET).parseClaimsJws(token).getBody();
    }

    public String generateToken(AdminDetail adminDetail) {
        Map<String, Object> claims = new HashMap<>();
        if (StringUtils.hasText(adminDetail.getUsername())) {
            claims.put(AdminDetail.ID, adminDetail.getId());
            claims.put(AdminDetail.USERNAME, adminDetail.getUsername());
        }
        return doGenerateToken(claims);
    }

    private String doGenerateToken(Map<String, Object> claims) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Config.JWT_TOKEN_VALIDITY_TIME))
                .signWith(SignatureAlgorithm.HS512, Secret.TOKEN_SECRET)
                .compact();
    }
}
