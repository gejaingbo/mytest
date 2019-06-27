package com.example.demo.rpc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



/**
 * @author gejiangbo
 * @Description
 * @date:2019/6/26
 * @mail jiangbo.ge@kuwo.cn
 */
public class ServerStart {
     public static void  main(String[] args){
//         SpringApplicationBuilder builder = new SpringApplicationBuilder(ServerStart.class);
         //修改Banner的模式为OFF,启动时控制台将不打印显示字符wow
//         builder.bannerMode(Banner.Mode.OFF).run(args);
         new AnnotationConfigApplicationContext(TestConfiguration.class);

     }
}

