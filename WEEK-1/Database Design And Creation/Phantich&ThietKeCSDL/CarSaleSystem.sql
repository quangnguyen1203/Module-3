CREATE TABLE customers(
	customerNumber INT NOT NULL PRIMARY KEY,
    customerName VARCHAR(50) NOT NULL,
    contactLastName VARCHAR(50) NOT NULL,
    contactFirstName VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    saleRepEmployeeNumber INT NOT NULL,
    creditLimit DOUBLE,
    FOREIGN KEY(saleRepEmployeeNumber) REFERENCES employees(employeeNumber)
);

CREATE TABLE orders(
	orderNumber INT NOT NULL PRIMARY KEY,
    orderDate DATE NOT NULL,
    requiredDate DATE NOT NULL,
    shippedDate DATE NOT NULL,
    `status` VARCHAR(15) NOT NULL, 
    comments TEXT, 
    quantityOrdered INT NOT NULL,
    priceEach DOUBLE NOT NULL,
    customerNumber INT NOT NULL,
    FOREIGN KEY(customerNumber) REFERENCES customers(customerNumber)
);

CREATE TABLE oderdetails(
	orderNumber INT NOT NULL,
    productCode VARCHAR(15) NOT NULL,
    FOREIGN KEY(orderNumber) REFERENCES orders(orderNumber),
    FOREIGN KEY(productCode) REFERENCES products(productCode)
);

CREATE TABLE payments(
	customerNumber INT NOT NULL PRIMARY KEY,
    checkNumber VARCHAR(50),
    paymentDate DATE NOT NULL,
    amount DOUBLE NOT NULL,
    FOREIGN KEY(customerNumber) REFERENCES customers(customerNumber)
);

CREATE TABLE products(
	productCode VARCHAR(15) NOT NULL PRIMARY KEY,
    productName VARCHAR(70) NOT NULL,
    productLine VARCHAR(50) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock INT NOT NULL,
    buyPrice DOUBLE NOT NULL,
    MSRP DOUBLE NOT NULL,
    FOREIGN KEY(productLine) REFERENCES productlines(productLine)
);

CREATE TABLE productlines(
	productLine VARCHAR(50) NOT NULL PRIMARY KEY,
    textDescription CHAR,
    image CHAR
);

CREATE TABLE employees(
	employeeNumber INT NOT NULL PRIMARY KEY,
    lastName VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    jobTitle VARCHAR(50) NOT NULL,
    reportTo INT NOT NULL,
    officeCode VARCHAR(10) NOT NULL, 
    FOREIGN KEY(reportTo) REFERENCES employees(employeeNumber),
    FOREIGN KEY(officeCode) REFERENCES offices(officeCode)
);

CREATE TABLE offices(
	officeCode VARCHAR(10) NOT NULL PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL
);