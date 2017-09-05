package io.pivotal.workshop;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.pivotal.workshop.domain.SnippetNotifier;

@SpringBootApplication
public class BootSnipperConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSnipperConsumerApplication.class, args);
	}
	
    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(SnippetNotifier snippetNotifier) {
        System.out.println("Received <" + snippetNotifier.getTitle() + " on " + snippetNotifier.getCreated() +">");
    }
}
