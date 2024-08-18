CREATE TABLE "accounts" (
    "id" INTEGER NOT NULL,
    "name" text,
    "balance" DECIMAL(12, 2),
    "currency" VARCHAR(3),
    "user_id" INTEGER,
    CONSTRAINT "accounts_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_account" FOREIGN KEY ("user_id") REFERENCES users(id)
)
