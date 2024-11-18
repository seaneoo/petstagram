CREATE TABLE "users"
(
    "id"         serial PRIMARY KEY,
    "username"   varchar(20) NOT NULL UNIQUE,
    "password"   bytea       NOT NULL,
    "created_at" timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "enabled"    bool        NOT NULL DEFAULT TRUE,
    "role"       varchar(10) NOT NULL DEFAULT 'user',
    CONSTRAINT "chk_username_format" CHECK ("username" ~ '^\w+$')
);

CREATE INDEX "idx_users_username" ON "users" ("username");
CREATE INDEX "idx_users_enabled" ON "users" ("username") WHERE "enabled" = TRUE;
