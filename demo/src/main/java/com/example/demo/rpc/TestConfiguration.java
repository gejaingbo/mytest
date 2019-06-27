package com.example.demo.rpc;

import com.example.demo.rpc.client.RpcProxy;
import com.example.demo.rpc.client.ServiceDiscovery;
import com.example.demo.rpc.server.RpcServer;
import com.example.demo.rpc.server.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/6/26
 * @mail jiangbo.ge@kuwo.cn
 */
@Configuration
@ComponentScan(value="com.example.demo.rpc")
public class TestConfiguration {

    public TestConfiguration() {
        System.out.println("Configuration容器启动初始化开始。。。");
    }
    @Bean
    public ServiceRegistry getregistry(){
        return new ServiceRegistry("127.0.0.1:8080");
    }
    @Bean
    public RpcServer getserver(){

            return new RpcServer("127.0.0.1:2181", this.getregistry());

    }

    @Bean
    public ServiceDiscovery getdiscovrey(){
        return new ServiceDiscovery("127.0.0.1:2181");
    }
    @Bean
    public RpcProxy getproxy(){
        ServiceDiscovery serviceDiscovery = this.getdiscovrey();
        return new RpcProxy(serviceDiscovery);
    }
}
