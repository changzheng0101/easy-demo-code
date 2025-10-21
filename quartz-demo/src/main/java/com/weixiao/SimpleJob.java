package com.weixiao;

import org.quartz.*;

import java.util.Date;

/**
 * @author changzheng.15
 * @date 2025年10月21日 20:32
 */
public class SimpleJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.out.println("Job says: " + jobSays + ", and val is: " + myFloatValue);

        Trigger trigger = context.getTrigger();
        Date nextFireTime = trigger.getNextFireTime();
        System.out.println("Next execution: " + nextFireTime);
    }
}
