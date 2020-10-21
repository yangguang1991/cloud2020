package com.example.springcloud.schdule;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: kevin yang
 * @Description:
 * @Date: create in 2020/10/20 18:09
 */
@Service
@Slf4j
public class PrintWordsJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println(jobExecutionContext.getMergedJobDataMap().get("trigger1").toString());
            System.out.println(jobExecutionContext.getMergedJobDataMap().get("jobDetail1").toString());
            System.out.println(jobExecutionContext.getJobDetail().getJobBuilder());
            System.out.println(jobExecutionContext.getMergedJobDataMap().get("job321"));
            log.info(new Date() + ",resChargingStationMapper.gunNumber()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
