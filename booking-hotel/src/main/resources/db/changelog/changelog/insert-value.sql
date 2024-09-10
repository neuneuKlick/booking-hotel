INSERT INTO users (username, email, password, role_type) VALUES
    ('Tom', 'tom21@gmail.com', '12345', 'ROLE_USER'),
    ('John','johnsilver@gmail.com', '12345', 'ROLE_ADMIN'),
    ('User','user@gmail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'ROLE_USER');

INSERT INTO hotels (name, title, city, address, location, rating, reviews) VALUES
    ('Wochenbrunner Chalets', 'Wellcome to ochenbrunner Chalets', 'Ellmau', 'Wochenbrunnweg, 6352 Ellmau, Austria', 9.0, 9.2, 143),
    ('Hotel New Imperial', 'Wellcome to Hotel New Imperial', 'Mumbai', 'Apsara cinema, Near Minerva talkies , Ali Bhai Premji Marg, Grant Road(E) Mumbai - 400007, 400007 Mumbai, India', 8.2, 9.0, 40);

INSERT INTO rooms (name, description, type, price, number_of_guests) VALUES
    ('Room number 3', 'Wochenbrunner Chalets provides accommodations with access to a sauna. Offering a family-friendly restaurant, the property also has free bikes and a garden.', 'Two-Bedroom Chalet', 3500, 2),
    ('Room', 'Featuring a 24-hour business center, the hotel has an outdoor pool, a fitness center and pampering spa treatments. Complimentary WiFi is available in all rooms.', 'Two-Bedroom Chalet', 1400, 4);

INSERT INTO bookings (check_in_date, check_out_date, room_id, user_id) VALUES
    ('2023-01-01', '2023-01-25', 2, 1),
    ('2023-02-01', '2023-02-25', 2, 1),
    ('2023-03-01', '2023-03-25', 1, 2),
    ('2023-04-01', '2023-04-25', 1, 2);