package com.example.demo.rpc.server;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/6/26
 * @mail jiangbo.ge@kuwo.cn
 */
public class ServiceRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRegistry.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private String registryAddress;

    public ServiceRegistry(String registryAddress){
      registryAddress = registryAddress;
    }
    public void register(String data){
        if(data!=null){
            ZooKeeper zk =connectServer();
            if(zk!=null){
                createNode(zk,data);
            }
        }
    }
    private ZooKeeper connectServer(){
        ZooKeeper zk =null;
        try {
            zk = new ZooKeeper(registryAddress, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                   if(event.getState() == Event.KeeperState.SyncConnected){
                       latch.countDown();
                   }
                }
            });
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return zk;
    }
    private void createNode(ZooKeeper zk,String data){
        try {
        byte[] bytes = data.getBytes();
        String path = zk.create("E:/zk/zookeeper/registry", bytes,ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        LOGGER.debug("create zookeeper node ({} => {})", path, data);
        } catch (KeeperException | InterruptedException e) {
            LOGGER.error("", e);
        }
    }

}
