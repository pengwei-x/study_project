package com.pw.elastic.controller;

/**
 * @author pengwei
 * @date 2021/3/24
 */
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DependsOn("org.apache.shardingsphere.elasticjob.lite.spring.boot.job.ElasticJobLiteAutoConfiguration")
public class OneOffJobController {

    @Resource(name = "manualScriptJobBean")
    private OneOffJobBootstrap manualScriptJob;

    @GetMapping("/execute")
    public String executeOneOffJob() {
        manualScriptJob.execute();
        return "{\"msg\":\"OK\"}";
    }
}