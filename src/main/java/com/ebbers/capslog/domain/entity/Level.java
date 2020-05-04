package com.ebbers.capslog.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Level {
    ERROR("error", "e"),
    WARNING("warning", "w"),
    INFO("info", "i");

    private final String description;
    private final String abbreviation;
}
