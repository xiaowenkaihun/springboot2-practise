package com.itwen.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 17:06
 * 文件描述：
 */
// @Component
public class MessageListener {
    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id){
        System.out.println("已经完成短信任务"+id);
        return "new"+id;
    }
}
