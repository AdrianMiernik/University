
INSERT INTO students
VALUES (1,  22, 'john@gmail.com', 'Engineering', 'John', 'Smith'),
       (2,  27, 'mari@gmail.com', 'Economics', 'Mari', 'Carlson'),
       (3,  33, 'sara@gmail.com', 'Economics',  'Sara', 'Mulk'),
       (4,  22, 'mick@gmail.com', 'Engineering', 'Mick', 'Orwell'),
       (5,  33, 'jake@gmail.com', 'Economics', 'Jake', 'Hook'),
       (6,  28, 'caroline@gmail.com', 'Engineering', 'Caroline', 'Kowalski'),
       (7,  34, 'adam@gmail.com', 'Engineering', 'Adam', 'Carlson'),
       (8,  18, 'anthony@gmail.com', 'Economics', 'Anthony', 'Obrian'),
       (9,  27, 'henry@gmail.com', 'Engineering', 'Henry', 'Jones'),
       (10,  19, 'blanca@gmail.com', 'Economics', 'Blanca', 'Evans'),
       (11,  42, 'clara@gmail.com', 'Engineering', 'Clara', 'Wright'),
       (12,  27, 'eva@gmail.com', 'Engineering', 'Eva', 'Lewis'),
       (13,  31, 'janine@gmail.com', 'Engineering', 'Janine', 'Wood');


INSERT INTO teachers
VALUES (1,  35, 'judi@gmail.com',  'Judi', 'Wilson' , 'International Trade'),
       (2,  28, 'kelly@gmail.com',  'Kelly', 'McDowel' , 'Java Language'),
       (3,  52, 'peter@gmail.com',  'Peter', 'Bush' , 'Unix Basics'),
       (4,  31, 'derek@gmail.com',  'Derek', 'Perry' , 'Python Language'),
       (5,  29, 'ashely@gmail.com',  'Ashley', 'Bundy' , 'Logistics'),
       (6,  45, 'katie@gmail.com',  'Katie', 'Prince' , 'Global Purchasing');

INSERT INTO teachers_students
VALUES (1,  1),
       (2,  2),
       (3,  3),
       (4,  7),
       (5,  7),
       (6,  5),
       (3,  6),
       (4,  8),
       (6,  9),
       (6,  10),
       (7,  11),
       (2,  7),
       (1,  13);