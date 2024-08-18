CREATE TABLE "transactions" (
    "id" INTEGER NOT NULL,
    "description" text,
    "amount" DECIMAL(12, 2),
    "currency" VARCHAR(3),
    "account_id" INTEGER,
    CONSTRAINT "transactions_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_account" FOREIGN KEY ("account_id") REFERENCES accounts(id)
)