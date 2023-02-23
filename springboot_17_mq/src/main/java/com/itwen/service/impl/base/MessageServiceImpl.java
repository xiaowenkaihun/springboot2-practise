package com.itwen.service.impl.base;

import com.itwen.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 16:15
 * 文件描述：
 */
// @Service
public class MessageServiceImpl implements MessageService {
    private ArrayList<String> msgList = new ArrayList<String>();
    @Override
    public void sendMessage(String id) {
        System.out.println("待发短信的订单已经纳入处理队列"+id);
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String id = msgList.remove(0);
        System.out.println("已经完成短信任务"+id);
        return id;
    }
}
