CREATE TABLE IF NOT EXISTS account_registration (

    id              BIGINT(32)      UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name      VARCHAR(128)    NULL,
    last_name       VARCHAR(128)    NULL,
    date_of_birth   DATETIME        NULL,
    nationality     CHAR(2)         NULL,
    street          VARCHAR(256)    NULL,
    city            VARCHAR(128)    NULL,
    state           VARCHAR(128)    NULL,
    postal_code     VARCHAR(32)     NULL,
    country         CHAR(2)         NULL,
    created_at      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME        NULL ON UPDATE CURRENT_TIMESTAMP
);