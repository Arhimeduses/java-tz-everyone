CREATE table customers(
    id SERIAL primary key,
    login TEXT NOT NULL UNIQUE,
    state TEXT NOT NULL
);