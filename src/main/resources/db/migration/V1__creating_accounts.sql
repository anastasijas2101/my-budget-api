CREATE TABLE accounts (
    id INTEGER NOT NULL,
    name VARCHAR,
    balance DECIMAL(12, 2),
    currency VARCHAR(3),
    CONSTRAINT "accounts_pkey" PRIMARY KEY (id)
)
