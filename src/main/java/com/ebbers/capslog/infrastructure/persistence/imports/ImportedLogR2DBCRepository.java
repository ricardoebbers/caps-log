package com.ebbers.capslog.infrastructure.persistence.imports;

import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ImportedLogR2DBCRepository extends ReactiveCrudRepository<Log, Long> {
    Mono<Log> findOneByUuid(UUID id);
}
