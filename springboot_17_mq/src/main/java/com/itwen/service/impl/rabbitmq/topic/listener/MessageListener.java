package com.itwen.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 13:51
 * 文件描述：
 */
// @Component
public class MessageListener {
    @RabbitListener(queues = "topic_queue")
    public void receive(String id){
        System.out.println("已经完成短信任务(Rabbitmq Topic1)   "+id);
    }
    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id){
        System.out.println("已经完成短信任务(Rabbitmq Topic2)   "+id);
    }
}
