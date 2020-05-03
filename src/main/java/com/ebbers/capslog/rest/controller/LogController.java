package com.ebbers.capslog.rest.controller;

import com.ebbers.capslog.domain.entity.Log;
import com.ebbers.capslog.domain.service.LogService;
import com.ebbers.capslog.rest.resource.LogResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService service;

    @GetMapping("/{id}")
    public Mono<Log> get(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Flux<Log> list() {
        return service.findAll();
    }

    @PostMapping
    public Mono<Log> create(@RequestBody Mono<LogResource> resource) {
        return service.save(resource.map(LogResource::toEntity));
    }
}
