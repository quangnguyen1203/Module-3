CREATE TABLE users(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(40),
    `Password` VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE roles(
	role_id INT AUTO_INCREMENT,
    role_name VARCHAR(50),
    PRIMARY KEY(role_id)
);

CREATE TABLE userrole(
	user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(role_id) REFERENCES roles(role_id)
);