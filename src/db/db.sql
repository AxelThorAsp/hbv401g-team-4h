DROP TABLE IF EXISTS Hotels;
DROP TABLE IF EXISTS Rooms;
DROP TABLE IF EXISTS Bookings;
DROP TABLE IF EXISTS Reviews;

CREATE TABLE Hotels (
                        id INTEGER PRIMARY KEY,
                        name TEXT,
                        stars REAL,
                        country TEXT,
                        city TEXT,
                        numrooms INTEGER,
                        hotelprice INTEGER
);

CREATE TABLE Rooms (
                       roomid INTEGER PRIMARY KEY,
                       type INTEGER,
                       bedcount INTEGER,
                       hotelid INTEGER,
                       FOREIGN KEY(hotelid) REFERENCES Hotels(id)
);

CREATE TABLE Bookings (
                          datefrom TEXT,
                          dateto TEXT,
                          name TEXT,
                          phonenum TEXT,
                          room INTEGER,
                          FOREIGN KEY(room) REFERENCES Rooms(roomid)
);

CREATE TABLE Reviews (
                         stars REAL,
                         review TEXT,
                         room INTEGER,
                         FOREIGN KEY(room) REFERENCES Rooms(roomid)
);

INSERT INTO Hotels (id, name, stars, country, city, numrooms, hotelprice)
VALUES (1, 'The Plaza Hotel', 4.5, 'USA', 'New York', 200, 300),
       (2, 'The Fairmont Royal York', 3.5, 'Canada', 'Toronto', 150, 250),
       (3, 'Four Seasons Hotel George V', 5.0, 'France', 'Paris', 300, 500),
       (4, 'The Westin Excelsior Rome', 4.0, 'Italy', 'Rome', 250, 400),
       (5, 'Hotel Arts Barcelona', 3.0, 'Spain', 'Barcelona', 100, 150),
       (6, 'The Ritz-Carlton Los Angeles', 3.5, 'USA', 'Los Angeles', 150, 200),
       (7, 'Pan Pacific Vancouver', 4.0, 'Canada', 'Vancouver', 180, 300),
       (8, 'Hyatt Regency Nice Palais de la Méditerranée', 4.5, 'France', 'Nice', 220, 400),
       (9, 'Hotel Danieli, Venice', 3.0, 'Italy', 'Venice', 120, 150),
       (10, 'The Ritz Madrid', 5.0, 'Spain', 'Madrid', 350, 600);

INSERT INTO Rooms (roomid, type, bedcount, hotelid)
VALUES (1, 1, 1, 1),
       (2, 3, 2, 1),
       (3, 1, 1, 2),
       (4, 2, 2, 2),
       (5, 3, 1, 3),
       (6, 2, 2, 3),
       (7, 1, 1, 4),
       (8, 2, 2, 4),
       (9, 1, 1, 5),
       (10, 2, 2, 5),
       (11, 1, 1, 6),
       (12, 2, 2, 6),
       (13, 3, 1, 7),
       (14, 2, 2, 7),
       (15, 1, 1, 8),
       (16, 2, 2, 8),
       (17, 3, 1, 9),
       (18, 2, 2, 9),
       (19, 3, 1, 10),
       (20, 2, 2, 10);

INSERT INTO Bookings (datefrom, dateto, name, phonenum, room)
VALUES ('2023-04-01', '2023-04-05', 'John Smith', '555-1234', 1),
       ('2023-04-01', '2023-04-05', 'Jane Doe', '555-5678', 2),
       ('2023-04-05', '2023-04-10', 'Bob Johnson', '555-9012', 3),
       ('2023-04-10', '2023-04-15', 'Alice Williams', '555-3456', 4),
       ('2023-04-15', '2023-04-20', 'Michael Brown', '555-7890', 5),
       ('2023-04-01', '2023-04-05', 'Emily Davis', '555-2345', 6),
       ('2023-04-05', '2023-04-10', 'Sarah Martinez', '555-6789', 7),
       ('2023-04-10', '2023-04-15', 'David Garcia', '555-0123', 8),
       ('2023-04-15', '2023-04-20', 'Jennifer Rodriguez', '555-4567', 9),
       ('2023-04-20', '2023-04-25', 'Robert Hernandez', '555-8901', 10);

INSERT INTO Reviews (stars, review, room)
VALUES (4.5, 'The room was clean and comfortable. The staff was friendly and helpful.', 1),
       (3.0, 'The room was okay, but the bathroom could have been cleaner. The staff was not very friendly.', 2),
       (5.0, 'The room was spacious and well-appointed. The staff was excellent and went above and beyond to make our stay enjoyable.', 3),
       (4.0, 'The room was nice, but a bit noisy due to the street traffic. The staff was friendly and accommodating.', 4),
       (2.5, 'The room was small and outdated. The staff was unresponsive to our requests.', 5),
       (4.5, 'The room was clean and modern. The staff was courteous and helpful.', 6),
       (3.5, 'The room was adequate, but the amenities were lacking. The staff was friendly.', 7),
       (5.0, 'The room was beautiful and well-maintained. The staff was friendly and attentive.', 8),
       (2.0, 'The room was dirty and poorly maintained. The staff was unhelpful.', 9),
       (4.0, 'The room was comfortable and clean. The staff was friendly and accommodating.', 10);
