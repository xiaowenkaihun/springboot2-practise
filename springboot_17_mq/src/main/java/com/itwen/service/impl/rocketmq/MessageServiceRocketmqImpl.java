package com.itwen.service.impl.rocketmq;

import com.itwen.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 19:22
 * 文件描述：
 */
// @Service
public class MessageServiceRocketmqImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发短信的订单已经纳入处理队列(rocketmq). id     "+id);
        // rocketMQTemplate.convertAndSend("order_id", id);
        SendCallback sendCallback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("send success");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("send fail");
            }
        };
        rocketMQTemplate.asyncSend("order_id", id, sendCallback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
