package com.ebbers.capslog.infrastructure.persistence.imports;

import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ImportedLogR2DBCRepository extends ReactiveCrudRepository<Log, Long> {
}
