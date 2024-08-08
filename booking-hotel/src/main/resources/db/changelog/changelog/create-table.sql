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
    hotel_id            INTEGER REFERENCES hotels (id) ON DELETE CASCADE
);

CREATE TABLE bookings
(
    id                  SERIAL PRIMARY KEY,
    check_in_date       TIMESTAMP,
    check_out_date      TIMESTAMP,
    room_id             INTEGER REFERENCES rooms (id) ON DELETE CASCADE,
    user_id             INTEGER REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE unavailable_dates
(
    id                  SERIAL PRIMARY KEY,
    check_in_date       TIMESTAMP,
    check_out_date      TIMESTAMP,
    room_id             INTEGER REFERENCES rooms (id) ON DELETE CASCADE
)
