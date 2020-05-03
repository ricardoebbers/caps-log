package com.ebbers.capslog.domain.imports;

import com.ebbers.capslog.domain.entity.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LogRepository {
    Mono<Log> findById(Long id);

    Mono<Log> save(Mono<Log> entity);

    Flux<Log> findAll();
}
