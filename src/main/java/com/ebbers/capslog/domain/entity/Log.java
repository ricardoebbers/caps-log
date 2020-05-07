package com.ebbers.capslog.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column
    @NotNull
    private String description;
    @Column
    @NotNull
    private String log;
    @Column
    @NotNull
    private String origin; //TODO: Deve extrair essa informaçao do token
    @Column
    @NotNull
    private LocalDateTime date;
    @Column
    @NotNull
    private Long quantity;

}
