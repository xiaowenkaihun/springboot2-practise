package com.itwen.service.impl.kafka;

import com.itwen.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/30 21:46
 * 文件描述：
 */

@Service
public class MessageServiceKafkaImpl implements MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发短信的订单已经纳入处理队列(rocketmq). id     "+id);
        kafkaTemplate.send("itwen", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
