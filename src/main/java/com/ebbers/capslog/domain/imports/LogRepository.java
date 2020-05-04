package com.ebbers.capslog.domain.imports;

import com.ebbers.capslog.domain.entity.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LogRepository {
    Mono<Log> findById(UUID id);

    Mono<Log> save(Log entity);

    Flux<Log> findAll();
}
