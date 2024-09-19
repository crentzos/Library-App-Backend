DROP TABLE IF EXISTS payment;

CREATE TABLE payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(45),
    amount DECIMAL(10,2)
);
