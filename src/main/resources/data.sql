INSERT INTO CUSTOMER(email, username, password) VALUES('mariana@thismail.com', 'mariana', 'password1');
INSERT INTO CUSTOMER(email, username, password) VALUES('maria@thismail.com', 'maria', 'password2');
INSERT INTO CUSTOMER(email, username, password) VALUES('joao@thismail.com', 'joao', 'password3');
INSERT INTO CUSTOMER(email, username, password) VALUES('francisco@thismail.com', 'chico', 'password4');
INSERT INTO CUSTOMER(email, username, password) VALUES('jose@thismail.com', 'jose', 'password5');

INSERT INTO CATEGORY(description) VALUES('Food');
INSERT INTO CATEGORY(description) VALUES('Travel');
INSERT INTO CATEGORY(description) VALUES('Fuel');
INSERT INTO CATEGORY(description) VALUES('Gifts');
INSERT INTO CATEGORY(description) VALUES('Merchandise');
INSERT INTO CATEGORY(description) VALUES('Accommodation');


INSERT INTO EXPENSE(amount, status, note, category_id, customer_id) VALUES(72.35, false, 'Team Lunch', 1, 2);
INSERT INTO EXPENSE(amount, status, note, category_id, customer_id) VALUES(986.12, false, 'Offsite', 6, 3);
INSERT INTO EXPENSE(amount, status, note, category_id, customer_id) VALUES(35.35, true, 'Branch visit', 3, 2);
INSERT INTO EXPENSE(amount, status, note, category_id, customer_id) VALUES(55, false, 'Gifts', 4, 4);
INSERT INTO EXPENSE(amount, status, note, category_id, customer_id) VALUES(82.99, true, 'Conference', 2, 5);