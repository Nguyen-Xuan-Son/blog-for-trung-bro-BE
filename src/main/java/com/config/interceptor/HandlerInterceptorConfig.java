package com.config.interceptor;

import com.constants.Config;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@Controller
public class HandlerInterceptorConfig implements org.springframework.web.servlet.HandlerInterceptor {

    private boolean apiIgnoreModifyToken(String pathApi) {
        Boolean result = Config.API_IGNORE_AUTHENTICATION.contains(pathApi);
        return result;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiRequest = request.getRequestURI();
        System.out.println("apiRequest: " + apiRequest);
//        Boolean apiIgnoredValid = apiIgnoreModifyToken(apiRequest);
//        System.out.println("apiIgnoredValid: " + apiIgnoredValid);
//        if (apiIgnoredValid) {
//            return true;
//        }

        // todo handle exception.
        return true;
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
