package com.itwen.controller;

import com.itwen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/18 16:21
 * 文件描述：
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{id}")
    public void order(@PathVariable  String id){
        orderService.order(id);
    };
}
