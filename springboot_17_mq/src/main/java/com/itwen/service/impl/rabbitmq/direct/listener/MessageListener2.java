package com.itwen.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 13:51
 * 文件描述：
 */
// @Component
public class MessageListener2 {
    @RabbitListener(queues = "direct_queue")
    public void receive(String id){
        System.out.println("已经完成短信任务(Rabbitmq Listener two)   "+id);
    }
}
