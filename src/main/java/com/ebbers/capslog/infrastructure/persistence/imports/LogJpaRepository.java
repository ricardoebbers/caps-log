package com.ebbers.capslog.infrastructure.persistence.imports;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogJpaRepository extends JpaRepository<Log, Long> {

    Page<Log> findByLevel(Level level, Pageable pageable);
}
