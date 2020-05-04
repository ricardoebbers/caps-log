package com.ebbers.capslog.domain.entity;

import com.ebbers.capslog.domain.entity.base.EntityBase;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Value
public class Log extends EntityBase<Log> {
    Level level;
    String description;
    String log;
    String origin;
    Long quantity;

    @Builder
    public Log(Long id, UUID uuid, LocalDateTime date, Long owner, Level level, String description, String log,
               String origin, Long quantity) {
        super(id, uuid, date, owner);
        this.level = level;
        this.description = description;
        this.log = log;
        this.origin = origin;
        this.quantity = quantity;
    }
}
