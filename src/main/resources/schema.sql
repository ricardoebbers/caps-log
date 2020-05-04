CREATE TABLE log
(
    id          SERIAL PRIMARY KEY,
    owner       BIGINT,
    level       VARCHAR(255),
    uuid        UUID,
    description VARCHAR(255),
    log         VARCHAR(255),
    origin      VARCHAR(255),
    date        TIMESTAMP,
    quantity    BIGINT
);