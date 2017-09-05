package io.pivotal.workshop;

import io.pivotal.workshop.domain.Snippet;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class BootSnippetProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSnippetProducerApplication.class, args);
    }

    private final RabbitTemplate template;

    @Autowired
    public BootSnippetProducerApplication(RabbitTemplate template){
        this.template = template;
    }

    @Scheduled(fixedDelay = 1000)
    public void sender() {
        Snippet snippet = new Snippet("JavaScript: Alert","alert('Hi there!');");
        template.convertAndSend(snippet);
    }
}