package com.itwen.service.impl.rabbitmq.direct;

import com.itwen.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 13:31
 * 文件描述：
 */
// @Service
public class MessageServiceRabbitmqDirectImpl implements MessageService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发短信的订单已经纳入处理队列,id(RabbitMQ direct)   "+id);
        amqpTemplate.convertAndSend("directExchange", "direct", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
