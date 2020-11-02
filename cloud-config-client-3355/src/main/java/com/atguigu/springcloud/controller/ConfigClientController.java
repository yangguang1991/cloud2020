package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-21 18:08
 * 修改完配置文件需要手动执行curl -X POST  "http://localhost:3355/actuator/refresh" ，来刷新配置，不用重启3355客户端即可获取github新的配置
 * 这比重启客户端的代价要小很多
 */
@RestController
@RefreshScope //自动刷新配置的功能，
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
