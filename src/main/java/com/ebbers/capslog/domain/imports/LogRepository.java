package com.ebbers.capslog.domain.imports;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LogRepository {
    Optional<Log> findById(Long id);

    Log save(Log entity);

    Page<Log> findAll(Pageable pageable);

    Page<Log> findByLevel(Level level, Pageable pageable);
}
