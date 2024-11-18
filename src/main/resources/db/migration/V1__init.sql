CREATE TABLE "users"
(
    "id"         serial PRIMARY KEY,
    "username"   varchar(20) NOT NULL UNIQUE,
    "password"   bytea       NOT NULL,
    "created_at" timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX "idx_users_username" ON "users" ("username");
