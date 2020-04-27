package com.config.interceptor;

import com.cache.SessionCache;
import com.constants.Config;
import com.constants.Message;
import com.constants.ResponseResult;
import com.utils.exception.ApplicationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@Controller
public class HandlerInterceptorConfig implements org.springframework.web.servlet.HandlerInterceptor  {

    private final SessionCache sessionCache;

    private boolean apiIgnoreModifyToken(String pathApi) {
        Boolean result = Config.API_IGNORE_AUTHENTICATION.contains(pathApi);
        return result;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String apiRequest = request.getRequestURI();
        Boolean apiIgnoredValid = apiIgnoreModifyToken(apiRequest);

        if (apiIgnoredValid) {
            return true;
        }

        String token = request.getHeader("Authorization");
        Boolean isTokenValid = sessionCache.checkValidToken(token);
        if (isTokenValid) {
            sessionCache.resetTimeExpiredToken(token);
            return true;
        } else {
            throw new ApplicationException(ResponseResult.INVALID_ACCESS_TOKEN, Message.TOKEN_INVALID);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // TODO
    }
}
