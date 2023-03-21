-- User Table --

DROP TABLE IF EXISTS USER;
CREATE TABLE USER(
email VARCHAR(50) PRIMARY KEY,
username VARCHAR(15) NOT NULL
);


-- Category Table --

DROP TABLE IF EXISTS CATEGORY;
CREATE TABLE CATEGORY(
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(50) NOT NULL
);

-- Expense Table --

DROP TABLE IF EXISTS EXPENSE;
CREATE TABLE EXPENSE(
id INT AUTO_INCREMENT PRIMARY KEY,
amount REAL NOT NULL,
note VARCHAR(75) NOT NULL,
status BOOLEAN,
category_id INT,
email VARCHAR(50),
foreign key (category_id) references CATEGORY(id),
foreign key (email) references USER(email)
);