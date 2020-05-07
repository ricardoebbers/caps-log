package com.ebbers.capslog.infrastructure.persistence;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.ebbers.capslog.domain.imports.LogRepository;
import com.ebbers.capslog.infrastructure.persistence.imports.LogJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Repository
public class LogRepositoryImpl implements LogRepository {

    private final LogJpaRepository repository;

    @Override
    public Optional<Log> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Log save(Log entity) {
        return repository.save(requireNonNull(entity));
    }

    @Override
    public Page<Log> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Log> findByLevel(Level level, Pageable pageable) {
        return repository.findByLevel(level, pageable);
    }
}
