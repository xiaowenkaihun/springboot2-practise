package com.itwen.service.impl.rabbitmq.topic.comfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：24岁没牵过女人的手
 * 日期：2022/12/26 13:37
 * 文件描述：
 */
// @Configuration
public class RabbitConfigTopic {

    @Bean
    public Queue TopicQueue(){
        return new Queue("topic_queue");
    }

    @Bean
    public Queue TopicQueue2(){
        return new Queue("topic_queue2");
    }

    // 一台交换机可以绑定多个主题

    @Bean
    public TopicExchange TopicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingTopic(){
        return BindingBuilder.bind(TopicQueue()).to(TopicExchange()).with("topic.*.id");
    }
    @Bean
    public Binding bindingTopic2(){
        return BindingBuilder.bind(TopicQueue2()).to(TopicExchange()).with("topic.abc.*");
    }

}
