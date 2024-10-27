create table users
(
    id           uuid                                               not null
        primary key,
    last_name    varchar(50)                                        not null
        constraint users_last_name_check
            check ((last_name)::text ~ '^[А-ЯЁ][а-яё]+$'::text),
    first_name   varchar(50)                                        not null
        constraint users_first_name_check
            check ((first_name)::text ~ '^[А-ЯЁ][а-яё]+$'::text),
    middle_name  varchar(50)
        constraint users_middle_name_check
            check ((middle_name)::text ~ '^[А-ЯЁ][а-яё]+$'::text),
    phone_number char(11)                                           not null
        unique
        constraint users_phone_number_check
            check (phone_number ~ '^7\d{10}$'::text),
    email        varchar(255)                                       not null
        unique
        constraint users_email_check
            check ((email)::text ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'::text),
    birth_date   date                                               not null,
    password     varchar(255)                                       not null,
    created_time timestamp with time zone default CURRENT_TIMESTAMP not null,
    updated_time timestamp with time zone default CURRENT_TIMESTAMP not null
);