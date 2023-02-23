package com.itwen.service.impl.rabbitmq.direct.comfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 13:37
 * 文件描述：
 */
// @Configuration
public class RabbitConfigDirect {

    @Bean
    public Queue directQueue(){
        return new Queue("direct_queue");
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("direct_queue2");
    }

    // 一台交换机可以绑定多个直连
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }
    @Bean
    public Binding bindingDirect2(){
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("direct2");
    }

}
