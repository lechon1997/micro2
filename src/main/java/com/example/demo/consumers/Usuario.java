package com.example.demo.consumers;

import com.example.demo.config.MensajesResta;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Usuario {

    @RabbitListener(queues = MensajesResta.QUEUE)
    public void consumeMessaggeFromQueue(String mensaje){
        System.out.println("RESTA MENSAJE: " + mensaje);
    }

}
