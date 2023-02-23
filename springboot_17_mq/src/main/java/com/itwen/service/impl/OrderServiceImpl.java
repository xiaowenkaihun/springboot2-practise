package com.itwen.service.impl;

import com.itwen.service.MessageService;
import com.itwen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 16:12
 * 文件描述：
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MessageService messageService;

    @Override
    public void order(String id) {
        // 一系列的操作，包含各种服务的调用，处理各种事务
        System.out.println("订单的处理开始");
        // 短信的处理
        messageService.sendMessage(id);
        // System.out.println("订单处理结束");
        System.out.println("----------");
    }
}
