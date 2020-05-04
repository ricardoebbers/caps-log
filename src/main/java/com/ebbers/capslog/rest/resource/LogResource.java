package com.ebbers.capslog.rest.resource;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class LogResource {
    private final Long owner;
    private final UUID id;
    private final Level level;
    private final String description;
    private final String log;
    private final String origin;
    private final LocalDateTime date;
    private final Long quantity;

    public static LogResource fromEntity(Log entity) {
        return LogResource.builder()
                .owner(entity.getOwner())
                .id(entity.getUuid())
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
                .owner(getOwner())
                .level(getLevel())
                .description(getDescription())
                .log(getLog())
                .origin(getOrigin())
                .date(getDate())
                .quantity(getQuantity())
                .build();
    }
}
