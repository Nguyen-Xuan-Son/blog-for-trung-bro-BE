package com.cache;

import com.entity.admin.SessionEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SessionCache {
    private static Map<String, SessionEntity> sessions = new HashMap<String, SessionEntity>();

    public void setSessions(String userId, SessionEntity sessionEntity) {
        sessions.put(userId, sessionEntity);
    }

    public void removeSession(String userId) {
        sessions.remove(userId);
    }

    public void clearSessions() {
        sessions.clear();
    }
}
