
CREATE TABLE product (
                         pid INT PRIMARY KEY,
                         title VARCHAR(255),
                         price DECIMAL(10,2),
                         description TEXT,
                         category_id INT,
                         FOREIGN KEY (category_id) REFERENCES category(id)
);