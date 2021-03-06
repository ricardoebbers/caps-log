package com.ebbers.capslog.domain.service;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LogService {

    Page<Log> findAll(Pageable pageable);

    Optional<Log> findById(Long id);

    Log save(Log entity);

    Page<Log> findByLevel(Level level, Pageable pageable);
}
