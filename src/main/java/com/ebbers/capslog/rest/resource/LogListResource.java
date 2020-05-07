package com.ebbers.capslog.rest.resource;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class LogListResource extends LogResource {

    LogListResource(Long id, Level level, String description, String origin,
                    LocalDateTime date, Long quantity) {
        super(id, level, description, null, origin, date, quantity);
    }

    public static LogListResource fromEntity(Log entity) {
        return new LogListResource(
                entity.getId(),
                entity.getLevel(),
                entity.getDescription(),
                entity.getOrigin(),
                entity.getDate(),
                entity.getQuantity());
    }

    public static List<LogListResource> fromEntity(List<Log> entities) {
        return entities.stream().map(LogListResource::fromEntity).collect(Collectors.toList());
    }

    public static Page<LogListResource> fromPage(Page<Log> entityPage) {
        return entityPage.map(LogListResource::fromEntity);
    }
}
