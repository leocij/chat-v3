package chatv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import chatv1.handler.WebsocketHandler;

@EnableWebSocket
@SpringBootApplication
public class ChatV1Application implements WebSocketConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ChatV1Application.class, args);
	}

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebsocketHandler(), "/chat");
	}
}
