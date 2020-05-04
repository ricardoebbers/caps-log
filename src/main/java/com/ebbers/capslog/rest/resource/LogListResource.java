package com.ebbers.capslog.rest.resource;

import com.ebbers.capslog.domain.entity.Level;
import com.ebbers.capslog.domain.entity.Log;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class LogListResource extends LogResource {

    LogListResource(Long owner, UUID id, Level level, String description, String origin,
                    LocalDateTime date, Long quantity) {
        super(owner, id, level, description, null, origin, date, quantity);
    }

    public static LogListResource fromEntity(Log entity) {
        return new LogListResource(
                entity.getOwner(),
                entity.getUuid(),
                entity.getLevel(),
                entity.getDescription(),
                entity.getOrigin(),
                entity.getDate(),
                entity.getQuantity());
    }
}
