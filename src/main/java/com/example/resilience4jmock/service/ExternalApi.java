package com.example.resilience4jmock.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ExternalApi {
    private final WebClient webClient;

    @CircuitBreaker(name = "externalServiceFoo")
    public Mono<String> retreiveData() {
        return webClient.get().uri("/external-data").retrieve().bodyToMono(String.class);
    }
}