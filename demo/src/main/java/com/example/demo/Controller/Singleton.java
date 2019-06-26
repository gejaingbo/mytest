package com.example.demo.Controller;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/29
 * @mail jiangbo.ge@kuwo.cn
 */
public class Singleton {
    private static Singleton singleton ;
    private Singleton(){}
    public Singleton getInstance(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

}
