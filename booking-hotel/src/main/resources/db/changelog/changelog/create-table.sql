CREATE TABLE users
(
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(150) UNIQUE NOT NULL,
    email       VARCHAR(150) UNIQUE NOT NULL,
    password    VARCHAR(150) NOT NULL,
    role_type   VARCHAR(50)
);

CREATE TABLE hotels
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(150) UNIQUE NOT NULL,
    title       VARCHAR(150) UNIQUE NOT NULL,
    city        VARCHAR(50) NOT NULL,
    address     VARCHAR(255) UNIQUE NOT NULL,
    location    DOUBLE PRECISION NOT NULL,
    rating      DOUBLE PRECISION NOT NULL,
    reviews     INTEGER NOT NULL
);

CREATE TABLE rooms
(
    id                  SERIAL PRIMARY KEY,
    name                VARCHAR(50) NOT NULL,
    description         VARCHAR(255) NOT NULL,
    type                VARCHAR(50) NOT NULL,
    price               INTEGER NOT NULL,
    number_of_guests    INTEGER NOT NULL,
    check_in_date       TIMESTAMP NOT NULL,
    check_out_date      TIMESTAMP NOT NULL,
    hotel_id            INTEGER REFERENCES hotels (id) NOT NULL
)
