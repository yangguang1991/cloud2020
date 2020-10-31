package com.example.springcloud.schdule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: kevin yang
 * @Description: quartz实现的定时
 * @Date: create in 2020/10/20 18:32
 */
@Component
public class ChargingRealTimeUtil {

    public static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public static void addCronJob(Class jobClass) {
        // 1、创建调度器Scheduler
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
            // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .usingJobData("jobDetail1", "这个Job用来测试的")
                    .usingJobData("job321", "321")
                    .withIdentity("job1", "group1").build();
            // 3、构建Trigger实例,每隔1s执行一次
            Date startDate = new Date();
            startDate.setTime(startDate.getTime() + 5000);
            Date endDate = new Date();
            endDate.setTime(startDate.getTime() + 100000);
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                    .usingJobData("trigger1", "这是jobDetail1的trigger")
                    .startNow()//立即生效
                    .startAt(startDate)
                    .endAt(endDate)
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                    .build();
            //4、执行
            scheduler.scheduleJob(jobDetail, cronTrigger);
            System.out.println("--------scheduler start ! ------------");
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addCronJob(PrintWordsJob.class);
    }

}
