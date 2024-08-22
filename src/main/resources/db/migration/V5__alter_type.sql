CREATE TYPE transaction_type AS ENUM ('EXPENSE', 'DEPOSIT');

ALTER TABLE transactions
    ALTER COLUMN type TYPE transaction_type
    USING type::transaction_type