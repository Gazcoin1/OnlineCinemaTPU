create table comment
(
    id           uuid                                               not null
        primary key,
    user_id      uuid
        unique
        references users,
    content      varchar(255)                                       not null,
    rating       double precision,
    created_time timestamp with time zone default CURRENT_TIMESTAMP not null
);