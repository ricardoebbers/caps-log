package com.ebbers.capslog.infrastructure.persistence.imports;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ImportedLogR2DBCRepository extends ReactiveCrudRepository<Log, Long> {
    Mono<Log> findOneByUuid(UUID id);

    Flux<Log> findByLevel(Level level, Pageable pageable);
}
