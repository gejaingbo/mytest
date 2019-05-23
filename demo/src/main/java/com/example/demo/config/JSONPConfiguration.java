package com.example.demo.config;

import com.example.demo.Controller.JsonpTestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/23
 * @mail jiangbo.ge@kuwo.cn
 */
@ControllerAdvice(basePackageClasses = {JsonpTestController.class})
public class JSONPConfiguration extends AbstractJsonpResponseBodyAdvice {
    public JSONPConfiguration(){
        super("callback","jsonp");
    }
}

