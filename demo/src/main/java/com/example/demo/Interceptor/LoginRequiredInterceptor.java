package com.example.demo.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/23
 * @mail jiangbo.ge@kuwo.cn
 */
public class LoginRequiredInterceptor extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(LoginRequiredInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info(request.getRequestURI());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info(request.getRequestURI());
        super.afterCompletion(request, response, handler, ex);
    }
}
