CREATE TABLE IF NOT EXISTS transfer (

    id              BIGINT(32)      UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_id      BIGINT(32)      UNSIGNED NOT NULL,
    amount          BIGINT          NOT NULL,
    currency        CHAR(3)         NOT NULL,
    status          VARCHAR(8)      NOT NULL,
    balance_after   BIGINT          NOT NULL,
    reference       VARCHAR(512)    NOT NULL,
    bank_route_id   BIGINT(32)      UNSIGNED NOT NULL,
    created_at      DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_transfer_account FOREIGN KEY (account_id) REFERENCES account (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT fk_transfer_bank_route FOREIGN KEY (bank_route_id) REFERENCES bank_route (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE UNIQUE INDEX idx_transfer_reference  ON transfer (reference);