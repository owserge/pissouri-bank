CREATE TABLE IF NOT EXISTS bank_route (

    id              BIGINT(32)      UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_name       VARCHAR(128)    NULL,
    iban            VARCHAR(32)     NULL,
    bic             VARCHAR(16)     NULL,
    swift_code      VARCHAR(32)     NULL,
    account_number  VARCHAR(32)     NULL,
    sort_code       VARCHAR(16)     NULL,
    nationality     VARCHAR(128)    NULL,
    street          VARCHAR(256)    NULL,
    city            VARCHAR(128)    NULL,
    state           VARCHAR(128)    NULL,
    postal_code     VARCHAR(32)     NULL,
    country         CHAR(2)         NULL,
    created_at      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME        NULL ON UPDATE CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX uq_bank_route_iban_bic         ON bank_route (iban, bic);
CREATE UNIQUE INDEX uq_bank_route_account_number   ON bank_route (account_number, sort_code);