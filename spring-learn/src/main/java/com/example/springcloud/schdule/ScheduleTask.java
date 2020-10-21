package com.example.springcloud.schdule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

/**
 * @Author: kevin yang
 * @Description:
 * @Date: create in 2020/10/20 16:33
 */
@Component
@EnableScheduling
public class ScheduleTask implements SchedulingConfigurer {

    Test1 test =new Test1("1");
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //TODO: 2019/4/19 定时任务表达式，实际项目可以从配置文件、数据库等中获取
        String cron = "*/5 * * * * *";
        taskRegistrar.addCronTask(test, cron);
    }
}
