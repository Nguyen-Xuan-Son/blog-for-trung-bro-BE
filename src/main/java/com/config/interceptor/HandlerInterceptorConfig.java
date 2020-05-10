package com.config.interceptor;

import com.cache.SessionCache;
import com.constants.Config;
import com.constants.Message;
import com.constants.ResponseResult;
import com.entity.IgnoreAuthenticateEntity;
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

    private boolean apiIgnoreModifyToken(String pathApi, String methodApi) {
        Boolean result = false;

        for (IgnoreAuthenticateEntity ignoreAuthenticateEntity: Config.API_IGNORE_AUTHENTICATION) {
            if (ignoreAuthenticateEntity.getMethodApi().equals(methodApi) && pathApi.startsWith(ignoreAuthenticateEntity.getPathApi())) {
                return true;
            }
        }

        return result;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String pathApiRequest = request.getRequestURI();
        String methodApiRequest = request.getMethod();
        Boolean apiIgnoredValid = apiIgnoreModifyToken(pathApiRequest, methodApiRequest);

        if (apiIgnoredValid) {
            return true;
        }

        String token = request.getHeader("Authorization");

        if (token == null) {
            throw new ApplicationException(ResponseResult.ACCESS_DENIED, Message.ACCESS_DENIED);
        }

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
