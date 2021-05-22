package ro.sd.a2.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.sd.a2.DTO.PayloadDTO;
import ro.sd.a2.DTO.TicketDTO;


@Service
public class RabbitSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${queue.rabbitmq.exchange}")
    private String exchange;

    @Value("${queue.rabbitmq.routingkey}")
    private String routingkey;

    public void send(PayloadDTO payload) {
        rabbitTemplate.convertAndSend(exchange, routingkey, payload);
    }
}