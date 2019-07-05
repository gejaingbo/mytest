package com.example.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/24
 * @mail jiangbo.ge@kuwo.cn
 */
@ControllerAdvice
public class Jsonp  implements ResponseBodyAdvice {

    private static final Pattern CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
    private final Log logger = LogFactory.getLog(this.getClass());
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private Charset charset;
    private SerializerFeature[] features;
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        HttpServletResponse response = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse();
        String value = servletRequest.getParameter("callback");
        if(value !=null){
            if (this.isValidJsonpQueryParam(value)) {
                JSONPObject jsonp = new JSONPObject(value, o);
                String text = JSON.toJSONString(jsonp.getJson(), this.features);
                String jsonpText = new StringBuilder(jsonp.getFunction()).append("(").append(text).append(")").toString();
                byte[] bytes = jsonpText.getBytes(this.charset);
                OutputStream out = null;
                try {
                    out = response.getOutputStream();
                    out.write(bytes);
                    out.flush();
                    out.close();
                } catch (IOException e) {

                }
            }
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Ignoring invalid jsonp parameter value: " + value);
            }
        }
      return o;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
    protected boolean isValidJsonpQueryParam(String value) {
        return CALLBACK_PARAM_PATTERN.matcher(value).matches();
    }
    public Jsonp() {
        super();
        this.charset = UTF8;
        this.features = new SerializerFeature[0];
    }


}

