package com.weixiao;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author changzheng.15
 * @date 2025年10月21日 20:13
 * <p>
 * 一次调度任务，需要：
 * <ul>
 *   <li>一个 {@link org.quartz.JobDetail} 描述具体的任务</li>
 *   <li>{@link org.quartz.Trigger} 去描述任务的触发时机</li>
 * </ul>
 * <p>
 * 之后通过 {@code scheduler.scheduleJob(job, trigger);} 进行注册。
 * </p>
 * <p>
 * <b>注意：</b>一个 trigger 只能对应一个 job。
 * </p>
 */
public class Main {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        JobDetail job2 = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("myJob2", "group1")
                .usingJobData("jobSays", "Hello World2!")
                .usingJobData("myFloatValue", 3.1415926f)
                .build();

        // Trigger objects are used to trigger the execution of Jobs.
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger2", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(job2, trigger2);
    }
}
