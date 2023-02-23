package com.itwen.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/30 21:51
 * 文件描述：
 */
@Component
public class MessageListener {
    @KafkaListener(topics = {"itwen"})
    public void onMessage(ConsumerRecord<String, String> record){
        System.out.println("已经完成短信任务(rocketmq Listener)   "+ record.value());
    }
}
