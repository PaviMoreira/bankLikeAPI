CREATE TABLE IF NOT EXISTS account (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(20) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS transaction (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(10, 2) NOT NULL,
    timestamp TIMESTAMP,
    sender_id BIGINT,
    receiver_id BIGINT,
    FOREIGN KEY (sender_id) REFERENCES account(id),
    FOREIGN KEY (receiver_id) REFERENCES account(id)
);