CREATE TABLE "users" (
    "id" INTEGER NOT NULL,
    "email" text,
    "password" text,
    "first_name" text,
    "last_name" text,
    CONSTRAINT "users_pkey" PRIMARY KEY ("id")
)