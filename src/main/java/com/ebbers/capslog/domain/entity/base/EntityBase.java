package com.ebbers.capslog.domain.entity.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@EqualsAndHashCode
@Getter
public abstract class EntityBase<T extends EntityBase<T>> {
    private final UUID uuid;
    private final LocalDateTime date;
    private final Long owner;
    @Id
    private Long id;

    protected EntityBase(Long id, UUID uuid, LocalDateTime date, Long owner) {
        this.id = Optional.ofNullable(id).orElse(null);
        this.uuid = Optional.ofNullable(uuid).orElse(UUID.randomUUID());
        this.date = Optional.ofNullable(date).orElse(LocalDateTime.now());
        this.owner = Optional.ofNullable(owner).orElseThrow(IllegalArgumentException::new);
    }
}
