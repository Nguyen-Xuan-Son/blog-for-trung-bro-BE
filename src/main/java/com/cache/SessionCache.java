package com.cache;

import com.constants.Config;
import com.entity.SessionEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class SessionCache {
    private static Map<String, SessionEntity> sessions = new HashMap<String, SessionEntity>();

    public void setSession(String userId, String token) {
        Date date= new Date();
        long currentTime = date.getTime();

        SessionEntity sessionEntity = new SessionEntity(token, currentTime, userId);
        sessions.put(token, sessionEntity);
    }

    public SessionEntity getInfoSessionByToken(String token) {
        SessionEntity sessionEntity = sessions.get(token);
        return sessionEntity;
    }

    public void removeSession(String userId) {
        sessions.remove(userId);
    }

    public void clearSessions() {
        sessions.clear();
    }

    public void resetTimeExpiredToken(String token) {
        Date date= new Date();
        long currentTime = date.getTime();

        SessionEntity sessionEntity = getInfoSessionByToken(token);

        SessionEntity sessionEntityResult = new SessionEntity(token, currentTime, sessionEntity.getUserId());
        sessions.put(token, sessionEntityResult);
    }

    public boolean checkValidToken(String token) {
        SessionEntity sessionEntity = getInfoSessionByToken(token);
        Date date= new Date();
        long currentTime = date.getTime();
        long lastRequestTime = sessionEntity.getLastRequestTime();

        return (currentTime - lastRequestTime) < Config.JWT_TOKEN_VALIDITY_TIME;
    }
}
