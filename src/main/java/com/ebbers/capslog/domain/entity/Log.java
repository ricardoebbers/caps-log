package com.ebbers.capslog.domain.entity;

import com.ebbers.capslog.domain.entity.base.EntityBase;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Builder
@Value
public class Log extends EntityBase<Log> {
    Level level;
    String description;
    String log;
    String origin;
    LocalDateTime date;
    Long quantity;
}
