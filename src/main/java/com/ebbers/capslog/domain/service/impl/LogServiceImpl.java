package com.ebbers.capslog.domain.service.impl;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.ebbers.capslog.domain.imports.LogRepository;
import com.ebbers.capslog.domain.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LogServiceImpl implements LogService {

    private final LogRepository repository;

    @Override
    public Flux<Log> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Log> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Log> save(Log entity) {
        return repository.save(entity);
    }

    @Override
    public Flux<Log> findByLevel(Level level, Pageable pageable) {
        return repository.findByLevel(level, pageable);
    }
}
