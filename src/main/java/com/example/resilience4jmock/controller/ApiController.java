package com.example.resilience4jmock.controller;

import com.example.resilience4jmock.service.ExternalApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final ExternalApi externalApi;

    @GetMapping("/principal")
    public Mono<String> principal() {
        return externalApi.retreiveData();
    }
}
