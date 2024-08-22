ALTER TABLE transactions
ADD COLUMN type VARCHAR,
ADD COLUMN converted_amount DECIMAL(12,2),
ADD COLUMN converted_currency VARCHAR(3)