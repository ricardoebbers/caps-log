package com.ebbers.capslog.domain.service.impl;

import com.ebbers.capslog.domain.entity.Log;
import com.ebbers.capslog.domain.imports.LogRepository;
import com.ebbers.capslog.domain.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LogServiceImpl implements LogService {

    private final LogRepository repository;

    @Override
    public Flux<Log> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Log> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Log> save(Mono<Log> entity) {
        return repository.save(entity);
    }
}
