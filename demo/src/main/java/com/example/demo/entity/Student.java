package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/23
 * @mail jiangbo.ge@kuwo.cn
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -1L;
    private String id;

    private String name;

    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
