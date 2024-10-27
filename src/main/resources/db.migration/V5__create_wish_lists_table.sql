create table wish_lists
(
    id      uuid not null
        primary key,
    film_id uuid
        references films,
    user_id uuid
        unique
        references users
);