package com.itwen.service.impl.activemq;

import com.itwen.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 16:46
 * 文件描述：
 */
// @Service
public class MessageServiceActivemqImpl implements MessageService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String id) {
        // jmsMessagingTemplate.convertAndSend(id);
        System.out.println("待发短信的订单已经纳入处理队列"+id);
        jmsMessagingTemplate.convertAndSend("order.queue.id", id);
    }

    @Override
    public String doMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("已经完成短信任务"+id);
        return id;
    }
}
