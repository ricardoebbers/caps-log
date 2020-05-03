package com.ebbers.capslog.infrastructure.persistence;

import com.ebbers.capslog.domain.entity.Log;
import com.ebbers.capslog.domain.imports.LogRepository;
import com.ebbers.capslog.infrastructure.persistence.imports.ImportedLogR2DBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Repository
public class LogR2DBCRepository implements LogRepository {

    private final ImportedLogR2DBCRepository repository;

    @Override
    public Mono<Log> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Log> save(Mono<Log> entity) {
        return repository.save(requireNonNull(entity.block()));
    }

    @Override
    public Flux<Log> findAll() {
        return repository.findAll();
    }
}
