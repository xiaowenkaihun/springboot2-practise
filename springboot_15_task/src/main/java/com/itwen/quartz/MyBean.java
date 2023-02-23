package com.itwen.quartz;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 14:12
 * 文件描述：
 */
@Component
public class MyBean {
    @Scheduled(cron = "0/5 * * * * ?")
    public void print(){
        System.out.println(Thread.currentThread().getName()+": spring task run....");
    }
}
