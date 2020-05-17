package edu.eci.arsw.Eturnity.sockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class EturnityWebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        System.out.println("holi");
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/Eturnity");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        System.out.println("Holi2");
        registry.addEndpoint("/et").withSockJS();
    }
}
