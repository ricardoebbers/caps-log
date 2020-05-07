package com.ebbers.capslog.rest.resource;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class LogResource {
    private final Long id;
    private final Level level;
    private final String description;
    private final String log;
    private final String origin;
    private final LocalDateTime date;
    private final Long quantity;

    public static LogResource fromEntity(Log entity) {
        return LogResource.builder()
                .id(entity.getId())
                .level(entity.getLevel())
                .description(entity.getDescription())
                .log(entity.getLog())
                .origin(entity.getOrigin())
                .date(entity.getDate())
                .quantity(entity.getQuantity())
                .build();
    }

    public Log toEntity() {
        return Log.builder()
                .level(getLevel())
                .description(getDescription())
                .log(getLog())
                .origin(getOrigin())
                .date(getDate())
                .quantity(getQuantity())
                .build();
    }
}
