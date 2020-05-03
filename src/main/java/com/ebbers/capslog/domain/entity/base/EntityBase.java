package com.ebbers.capslog.domain.entity.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@EqualsAndHashCode
@Getter
public abstract class EntityBase<T extends EntityBase<T>> {
    @Id
    private Long id;
    private UUID uuid;
}
