package com.ebbers.capslog.rest.controller;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.service.LogService;
import com.ebbers.capslog.rest.resource.LogListResource;
import com.ebbers.capslog.rest.resource.LogResource;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Log by Id"),
            @ApiResponse(responseCode = "404", description = "Log not found")
    })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<LogResource>> get(@PathVariable UUID id) {
        return service.findById(id)
                .map(LogResource::fromEntity)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all logs")
    })
    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public Flux<LogListResource> list() {
        return service.findAll().map(LogListResource::fromEntity);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all logs")
    })
    @GetMapping(value = "/level", produces = APPLICATION_JSON_VALUE)
    public Flux<LogListResource> list(
            @RequestParam Level level,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "ASC") Direction direction,
            @RequestParam(defaultValue = "", required = false) String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, (sort.isEmpty()) ? Sort.unsorted() : Sort.by(direction, sort));
        return service.findByLevel(level, pageable).map(LogListResource::fromEntity);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Log by Id"),
            @ApiResponse(responseCode = "404", description = "Log not found")
    })
    @PostMapping(value = "/", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<LogResource>> create(@RequestBody LogResource resource) {
        return service.save(resource.toEntity())
                .map(LogResource::fromEntity)
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }
}
