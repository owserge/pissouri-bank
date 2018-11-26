-- V1.1.0 Account bootstrap script
-- Creates an account, by recording account details and account bank routing information.

-- The account registration record
INSERT INTO account_registration (
    id,
    first_name,
    last_name,
    date_of_birth,
    nationality,
    street,
    city,
    postal_code,
    country)
VALUES (
    1,
    'John',
    'Cash',
    '1985-10-25',
    'GB',
    '1 God Save the Queen Ave',
    'London',
    'EC2700',
    'UK');

-- The account bank route information
INSERT INTO bank_route (
    id,
    full_name,
    iban,
    bic,
    swift_code,
    account_number,
    sort_code,
    nationality,
    street,
    city,
    postal_code,
    country
)
VALUES (
    1,
    'John F. Cash',
    'PB63910000004543',
    'PBBE10080',
    'PB10080',
    '90001050',
    '100090',
    'CY',
    '1 King Ave',
    'Paphos',
    '5200',
    'CY');

-- The actual account record, associated with registration and bank route information
INSERT INTO account (
    id,
    registration_id,
    bank_route_id,
    number,
    currency,
    balance,
    reference,
    created_at,
    updated_at
)
VALUES (
    1,
    1,
    1,
    'PB100042',
    'EUR',
    32750,
    '4d2e6b5b-e1db-4227-b117-c3644b4f31a6',
    '2018-07-01',
    '2018-07-01');