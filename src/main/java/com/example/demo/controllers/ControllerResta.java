package com.example.demo.controllers;

import com.example.demo.config.MensajesResta;
import com.example.demo.models.Calculadora;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resta")
public class ControllerResta {
    @Autowired
    private RabbitTemplate template;

    @GetMapping("/{num1}/{num2}")
    private Integer restar(@PathVariable("num1") Integer num1, @PathVariable("num2") Integer num2 ){
        Calculadora calculadora = new Calculadora();
        template.convertAndSend(MensajesResta.EXCHANGE, MensajesResta.ROUTING_KEY, "procesando resta");
        return calculadora.restar(num1,num2);
    }
}
