package com.ebbers.capslog.domain.service.impl;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.ebbers.capslog.domain.imports.LogRepository;
import com.ebbers.capslog.domain.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LogServiceImpl implements LogService {

    private final LogRepository repository;

    @Override
    public Page<Log> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Log> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Log save(Log entity) {
        return repository.save(entity);
    }

    @Override
    public Page<Log> findByLevel(Level level, Pageable pageable) {
        return repository.findByLevel(level, pageable);
    }
}
