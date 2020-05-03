package com.ebbers.capslog.rest.resource;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import lombok.Builder;
import lombok.Value;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class LogResource {
    UUID id;
    Level level;
    String description;
    String log;
    String origin;
    LocalDateTime date;
    Long quantity;

    public static Mono<LogResource> from(Mono<Log> entity) {
        return entity.map(it -> LogResource.builder()
                .id(it.getUuid())
                .level(it.getLevel())
                .description(it.getDescription())
                .log(it.getLog())
                .origin(it.getOrigin())
                .date(it.getDate())
                .quantity(it.getQuantity())
                .build());
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
