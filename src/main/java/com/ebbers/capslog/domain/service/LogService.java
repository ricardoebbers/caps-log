package com.ebbers.capslog.domain.service;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LogService {

    Flux<Log> findAll();

    Mono<Log> findById(UUID id);

    Mono<Log> save(Log entity);

    Flux<Log> findByLevel(Level level, Pageable pageable);
}
