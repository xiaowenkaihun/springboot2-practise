package com.itwen.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 19:36
 * 文件描述：
 */
// @Component
// @RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
public class MessageListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String id) {
        System.out.println("已经完成短信任务(rocketmq Listener)   "+id);
    }
}
