create table films
(
    id         uuid         not null
        primary key,
    name       varchar(255) not null,
    duration   integer      not null,
    rating     double precision,
    comment_id uuid
        references comment
);