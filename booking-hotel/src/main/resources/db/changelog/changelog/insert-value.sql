INSERT INTO users (username, email, password) VALUES
    ('Tom', 'tom21@gmail.com', '12345'),
    ('John','johnsilver@gmail.com', '12345');

INSERT INTO hotels (name, title, city, address, location, rating, reviews) VALUES
    ('Wochenbrunner Chalets', 'Wellcome to ochenbrunner Chalets', 'Ellmau', 'Wochenbrunnweg, 6352 Ellmau, Austria', 9.0, 9.2, 143),
    ('Hotel New Imperial', 'Wellcome to Hotel New Imperial', 'Mumbai', 'Apsara cinema, Near Minerva talkies , Ali Bhai Premji Marg, Grant Road(E) Mumbai - 400007, 400007 Mumbai, India', 8.2, 9.0, 40);

INSERT INTO rooms (name, description, type, price, number_of_guests) VALUES
    ('Room number 3', 'Wochenbrunner Chalets provides accommodations with access to a sauna. Offering a family-friendly restaurant, the property also has free bikes and a garden.', 'Two-Bedroom Chalet', 3500, 2),
    ('Room', 'Featuring a 24-hour business center, the hotel has an outdoor pool, a fitness center and pampering spa treatments. Complimentary WiFi is available in all rooms.', 'Two-Bedroom Chalet', 1400, 4);

INSERT INTO bookings (check_in_date, check_out_date) VALUES
    ('2023-01-01 00:00:00', '2023-01-25 00:00:00'),
    ('2023-02-01 00:00:00', '2023-02-25 00:00:00'),
    ('2023-03-01 00:00:00', '2023-03-25 00:00:00'),
    ('2023-04-01 00:00:00', '2023-04-25 00:00:00');