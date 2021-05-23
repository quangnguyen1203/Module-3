SELECT c.customerNumber,customerName,phone,paymentDate,amount 
FROM customers c
INNER JOIN payments p ON c.customerNumber = p.customerNumber
WHERE city = 'Las Vegas';

SELECT c.customerNumber, c.customerName, o.orderNumber, o.status
FROM customers c
LEFT JOIN orders o
ON c.customerNumber = o.customerNumber;

SELECT c.customerNumber, c.customerName, o.orderNumber, o.status
FROM customers c 
LEFT JOIN orders o ON c.customerNumber = o.customerNumber
WHERE orderNumber is null;