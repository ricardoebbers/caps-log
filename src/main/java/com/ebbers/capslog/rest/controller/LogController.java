package com.ebbers.capslog.rest.controller;

import com.ebbers.capslog.domain.service.LogService;
import com.ebbers.capslog.rest.resource.LogListResource;
import com.ebbers.capslog.rest.resource.LogResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<LogResource>> get(@PathVariable UUID id) {
        return service.findById(id)
                .map(LogResource::fromEntity)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping
    public Flux<LogListResource> list() {
        return service.findAll().map(LogListResource::fromEntity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<LogResource>> create(@RequestBody LogResource resource) {
        return service.save(resource.toEntity())
                .map(LogResource::fromEntity)
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }
}
