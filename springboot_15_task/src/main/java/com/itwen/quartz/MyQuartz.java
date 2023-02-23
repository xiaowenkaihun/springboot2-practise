package com.itwen.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 13:37
 * 文件描述：
 */
public class MyQuartz extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz task run ...");
    }
}
