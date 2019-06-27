package com.example.demo.rpc.service.impl;

import com.example.demo.rpc.RpcService;
import com.example.demo.rpc.service.HelloServie;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/6/26
 * @mail jiangbo.ge@kuwo.cn
 */
@RpcService(HelloServie.class)
public class HelloServiceImpl implements HelloServie {
    @Override
    public String hello(String name) {
        return name;
    }
}
