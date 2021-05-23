SELECT status FROM orders
GROUP BY status;

SELECT status,COUNT(status) as 'So luong status' 
FROM orders
GROUP BY status;

SELECT status, SUM(quantityOrdered*priceEach) as amount 
FROM orders o
INNER JOIN orderdetails od ON o.orderNumber = od.orderNumber
GROUP BY status;

SELECT orderNumber , SUM(quantityOrdered*priceEach) FROM orderdetails
GROUP BY orderNumber;

SELECT year(orderDate) as year, SUM(quantityOrdered*priceEach) FROM orders o
INNER JOIN orderdetails od ON o.orderNumber = od.orderNumber
WHERE status = 'shipped'
GROUP BY year
HAVING year > 2003;