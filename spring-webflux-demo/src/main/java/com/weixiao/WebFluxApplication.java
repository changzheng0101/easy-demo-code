package com.weixiao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalTime;

/**
 * @author changzheng
 * @date 2025年10月28日 16:28
 */
@SpringBootApplication
@Slf4j
public class WebFluxApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        consumeServerSentEvent();
    }

    public void consumeServerSentEvent() {
        WebClient client = WebClient.create("http://localhost:8080");
        ParameterizedTypeReference<ServerSentEvent<String>> type
                = new ParameterizedTypeReference<>() {
        };

        Flux<ServerSentEvent<String>> eventStream = client.get()
                .uri("/stream-sse")
                .retrieve()
                .bodyToFlux(type);

        eventStream.subscribe(
                content -> log.info("Time: {} - event: name[{}], id [{}], content[{}] ",
                        LocalTime.now(), content.event(), content.id(), content.data()),
                error -> log.error("Error receiving SSE: {}", error),
                () -> log.info("Completed!!!"));
    }


}
