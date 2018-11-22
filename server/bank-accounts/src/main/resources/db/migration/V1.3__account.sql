CREATE TABLE account (

    id              BIGINT(32)      UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    registration_id BIGINT(32)      UNSIGNED NOT NULL,
    bank_route_id   BIGINT(32)      UNSIGNED NOT NULL,
    number          VARCHAR(256)    NOT NULL,
    balance         BIGINT(32)      UNSIGNED NOT NULL DEFAULT 0,
    currency        CHAR(3)         NOT NULL,
    reference       VARCHAR(512)    NOT NULL,
    created_at      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      DATETIME        NULL ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_account_registration FOREIGN KEY (registration_id) REFERENCES registration (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT fk_account_bank_route FOREIGN KEY (bank_route_id) REFERENCES bank_route (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE UNIQUE INDEX idx_account_number      ON account (number);
CREATE UNIQUE INDEX idx_account_reference   ON account (reference);