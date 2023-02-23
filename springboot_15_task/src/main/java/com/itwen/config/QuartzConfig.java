package com.itwen.config;

import com.itwen.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 13:41
 * 文件描述：
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printJobDetail(){
        // 绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printTrigger(){
        // 绑定对应的工作明细
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? ");
        // 0秒0分0点1月1号星期几 日期和星期几不同时规定
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheduleBuilder).build();
    }
}

