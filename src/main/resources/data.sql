
INSERT INTO students
VALUES (1,  22, 'john@gmail.com', 'Engineering', 'John', 'Smith'),
       (2,  27, 'mari@gmail.com', 'Economics', 'Mari', 'Carlson'),
       (3,  33, 'sara@gmail.com', 'Economics',  'Sara', 'Mulk'),
       (4,  22, 'mick@gmail.com', 'Engineering', 'Mick', 'Orwell'),
       (5,  33, 'jake@gmail.com', 'Economics', 'Jake', 'Hook'),
       (6,  28, 'caroline@gmail.com', 'Engineering', 'Caroline', 'Kowalski'),
       (7,  31, 'ted@gmail.com', 'Engineering', 'Ted', 'Obrian');


INSERT INTO teachers
VALUES (1,  35, 'judi@gmail.com',  'Judi', 'Wilson' , 'International Trade'),
       (2,  41, 'kelly@gmail.com',  'Kelly', 'McDowel' , 'Java Language'),
       (3,  52, 'peter@gmail.com',  'Peter', 'Bush' , 'Unix Basics'),
       (4,  41, 'derek@gmail.com',  'Derek', 'Perry' , 'Python Language'),
       (5,  41, 'ashely@gmail.com',  'Ashley', 'Bundy' , 'Logistics'),
       (6,  41, 'katie@gmail.com',  'Katie', 'Prince' , 'Global Purchasing');

INSERT INTO teachers_students
VALUES (1,  1),
       (2,  2),
       (3,  3),
       (4,  7),
       (5,  6),
       (6,  5),
       (1,  4);