package com.pw.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author pengwei
 * @date 2021/3/24
 */
@SpringBootApplication

public class ElasticJobApplication {
    public static void main(String[] args) {
        //EmbedZookeeperServer.start(2181);
        SpringApplication.run(ElasticJobApplication.class,args);
    }
}
