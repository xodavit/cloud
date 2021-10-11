INSERT INTO users(id, username)
VALUES (1, 'admin'),
       (2, 'user2'),
       (3, 'user3'),
       (4, 'user4'),
       (5, 'user5');

INSERT INTO payments(id, sender_id, amount, comment)
VALUES (1, 1, 10000, 'user1'),
       (2, 2, 20000, 'user2'),
       (3, 3, 30000, 'user3'),
       (4, 4, 40000, 'user4'),
       (5, 5, 50000, 'user5'),
       (6, 1, 90000, 'user1'),
       (7, 5, 50000, 'user5');
