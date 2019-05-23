package com.example.demo.config;

import com.example.demo.Interceptor.LoginRequiredInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/23
 * @mail jiangbo.ge@kuwo.cn
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer  {
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("add interceptors");
        registry.addInterceptor(new LoginRequiredInterceptor());
    }

}
