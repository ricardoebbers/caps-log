package com.ebbers.capslog.domain.service;

import com.ebbers.capslog.domain.entity.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LogService {

    Flux<Log> findAll();

    Mono<Log> findById(Long id);

    Mono<Log> save(Mono<Log> entity);

}
