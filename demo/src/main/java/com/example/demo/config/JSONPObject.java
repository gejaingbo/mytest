package com.example.demo.config;

import java.io.Serializable;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/24
 * @mail jiangbo.ge@kuwo.cn
 */
public class JSONPObject implements Serializable {
    private static final long serialVersionUID = -7634081032767024781L;

    private String function;

    private Object json;

    public JSONPObject(String function, Object json){
        this.function = function;
        this.json = json;
    }

    public String getFunction() {
        return function;
    }

    public Object getJson() {
        return json;
    }

    public JSONPObject setFunction(String function) {
        this.function = function;
        return this;
    }

    public JSONPObject setJson(Object json) {
        this.json = json;
        return this;
    }

}
