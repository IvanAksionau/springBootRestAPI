-- Insert data into the address table
INSERT INTO address (street, city, country)
VALUES
    ('123 Main Street', 'New York', 'USA'),
    ('456 Oak Avenue', 'Los Angeles', 'USA'),
    ('789 Pine Road', 'Chicago', 'USA');

-- Insert data into the employee table
INSERT INTO employee (name, address_id, email, phone)
VALUES
    ('John Doe', 1, 'john.doe@example.com', 123456789),
    ('Jane Smith', 2, 'jane.smith@example.com', 987654321),
    ('Michael Johnson', 3, 'michael.johnson@example.com', 555123456);
