package com.heartrateworker.heartrateworker.conf;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConf {
    @Bean
    public Queue queue_heart(){
        return new Queue("queue_heart");
    }


    @Bean
    public Queue queue2() {
        return new Queue("queue_heart_emergency");
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
