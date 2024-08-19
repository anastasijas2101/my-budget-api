
ALTER TABLE "accounts" DROP CONSTRAINT "fk_account";
ALTER TABLE "accounts" DROP COLUMN "user_id";

DROP TABLE "users";

