INSERT INTO "user" (id, username, email, password) VALUES
    (1, 'Tom', 'tom21@gmail.com', '12345'),
    (2, 'John','johnsilver@gmail.com', '12345');

INSERT INTO "hotel" (id, name, title, city, address, location, rating, reviews) VALUES
    (1, 'Wochenbrunner Chalets', 'Wellcome to ochenbrunner Chalets', 'Ellmau', 'Wochenbrunnweg, 6352 Ellmau, Austria', 9.0, 9.2, 143),
    (2, 'Hotel New Imperial', 'Wellcome to Hotel New Imperial', 'Mumbai', 'Apsara cinema, Near Minerva talkies , Ali Bhai Premji Marg, Grant Road(E) Mumbai - 400007, 400007 Mumbai, India', 8.2, 9.0, 40);

INSERT INTO "room" (id, name, description, type, price, number_of_guests, check_in_date, check_out_date, hotel_id) VALUES
    (1, 'Room number 3', 'Wochenbrunner Chalets provides accommodations with access to a sauna. Offering a family-friendly restaurant, the property also has free bikes and a garden.', 'Two-Bedroom Chalet', 3500, 2, '2023-01-01 00:00:00', '2023-01-30 00:00:00', 1),
    (2, 'Room', 'Featuring a 24-hour business center, the hotel has an outdoor pool, a fitness center and pampering spa treatments. Complimentary WiFi is available in all rooms.', 'Two-Bedroom Chalet', 1400, 4, '2023-04-01 00:00:00', '2023-04-27 00:00:00', 2);