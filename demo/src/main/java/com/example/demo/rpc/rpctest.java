package com.example.demo.rpc;

import com.example.demo.rpc.client.RpcProxy;

import com.example.demo.rpc.service.HelloServie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/6/26
 * @mail jiangbo.ge@kuwo.cn
 */


public class rpctest {
    @Autowired
    private RpcProxy rpcProxy;

    @Test
    public void helloTest() {
        HelloServie helloService = rpcProxy.create(HelloServie.class);
        String result = helloService.hello("World");
    }
}
