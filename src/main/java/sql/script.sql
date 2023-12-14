create table equipo
(
    id_equipo          bigint       not null
        primary key,
    escudo             varchar(255) null,
    fecha_creacion     datetime(6)  null,
    fecha_modificacion datetime(6)  null,
    nombre_equipo      varchar(255) null,
    puntuacion         bigint       null
);

create table equipo_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table juego
(
    id_juego         bigint       not null
        primary key,
    descripcion      varchar(255) null,
    dificultad_juego varchar(255) null,
    intentos_max     bigint       null
);

create table juego_palabra
(
    id_juego_palabra bigint not null
        primary key,
    id_juego         bigint null,
    id_palabra       bigint null
);

create table juego_palabra_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table juego_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table jugador
(
    id_jugador         bigint       not null
        primary key,
    avatar             varchar(255) null,
    fecha_creacion     datetime(6)  null,
    fecha_modificacion datetime(6)  null,
    puntuacion         bigint       null,
    usuario            varchar(255) null,
    id_equipo          bigint       null
);

create table jugador_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table palabras
(
    id_palabra  bigint       not null
        primary key,
    dif_palabra varchar(255) null,
    palabra     varchar(255) null
);

create table palabras_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table partida
(
    id_partida      bigint       not null
        primary key,
    hora_comienzo   datetime(6)  null,
    hora_final      datetime(6)  null,
    num_intento     bigint       null,
    palabra_intento varchar(255) null,
    puntuacion      bigint       null,
    id_juego        bigint       null,
    id_jugador      bigint       null
);

create table partida_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table spring_session
(
    PRIMARY_ID            char(36)     not null
        primary key,
    SESSION_ID            char(36)     not null,
    CREATION_TIME         bigint       not null,
    LAST_ACCESS_TIME      bigint       not null,
    MAX_INACTIVE_INTERVAL int          not null,
    EXPIRY_TIME           bigint       not null,
    PRINCIPAL_NAME        varchar(100) null,
    constraint SPRING_SESSION_IX1
        unique (SESSION_ID)
);

create index SPRING_SESSION_IX2
    on spring_session (EXPIRY_TIME);

create index SPRING_SESSION_IX3
    on spring_session (PRINCIPAL_NAME);

create table spring_session_attributes
(
    SESSION_PRIMARY_ID char(36)     not null,
    ATTRIBUTE_NAME     varchar(200) not null,
    ATTRIBUTE_BYTES    blob         not null,
    primary key (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
    constraint SPRING_SESSION_ATTRIBUTES_FK
        foreign key (SESSION_PRIMARY_ID) references spring_session (PRIMARY_ID)
            on delete cascade
);


