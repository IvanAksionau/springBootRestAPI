--use employee_db;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS address;
CREATE TABLE IF NOT EXISTS address (
    id BIGINT NOT NULL AUTO_INCREMENT,
    street VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS employee (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    address_id BIGINT,
    email VARCHAR(255),
    phone INT,
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE
);
