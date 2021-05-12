CREATE TABLE customers(
	customer_number INT NOT NULL PRIMARY KEY,
    fullname VARCHAR(100),
    address VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE accounts(
	account_number INT NOT NULL PRIMARY KEY,
    account_type VARCHAR(100),
    accoint_opendate DATE,
    balance DOUBLE,
    FOREIGN KEY(account_number) REFERENCES customers(customer_number)
);

CREATE TABLE transactions(
	tran_number INT NOT NULL PRIMARY KEY,
    account_number INT,
    tran_time DATETIME,
    amounts DOUBLE,
    descriptions VARCHAR(100),
    FOREIGN KEY(account_number) REFERENCES accounts(account_number)
);