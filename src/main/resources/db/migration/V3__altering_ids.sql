    ALTER TABLE transactions
        ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;

    ALTER TABLE accounts
        ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;