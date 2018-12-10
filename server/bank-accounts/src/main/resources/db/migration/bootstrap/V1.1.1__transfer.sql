-- V1.1.1 Transfer bootstrap script
-- A list of bank account transfers for the bootstrap account.

-- Bank route information
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
    country)
VALUES (
    11,
    'TERRA NOVA Ltd',
    'CY75910000004587',
    'CYBE17580',
    NULL,
    NULL,
    NULL,
    'CY',
    '5 MAKARIOU Ave',
    'Nicosia',
    '2200',
    'CY'), (

    12,
    'TransferWise Ltd',
    'GB75828000008310',
    'GB8011287',
    NULL,
    '92501054',
    '100091',
    'UK',
    '28 United City Str',
    'Manchester',
    'EC7255',
    'UK'), (

    13,
    'Jack Rabbit',
    'AU63910000004543',
    NULL,
    'AU9004559087',
    NULL,
    NULL,
    'AU',
    '13 Music and Coffee Str',
    'Melbourne',
    'ML5211',
    'AU'), (

    14,
    'PayPal US Inc.',
    'US95910000874090',
    'US9010095',
    NULL,
    NULL,
    NULL,
    'US',
    '1 Times Square Ave',
    'NYC',
    '7500',
    'US'), (

    15,
    'Quality Steaks Ltd',
    'CY83910000007593',
    'CYBE19280',
    NULL,
    NULL,
    NULL,
    'CY',
    '7 Zenon Sqr',
    'Larnaca',
    '4200',
    'CY');

-- Transfers
INSERT INTO transfer (
    id,
    account_id,
    amount,
    currency,
    status,
    balance_after,
    reference,
    bank_route_id,
    created_at)
VALUES (
    1,
    1,
    -2750,
    'EUR',
    'ACCEPTED',
    18500,
    'eec6671b-c0d4-4833-9779-f4cbdb117eb7',
    11,
    '2018-07-01'), (

    2,
    1,
    -3875,
    'EUR',
    'ACCEPTED',
    16500,
    '0d0173d9-898b-4e2f-a762-2af6bbc461eb',
    11,
    '2018-07-02'), (

    3,
    1,
    -1820,
    'EUR',
    'ACCEPTED',
    11500,
    '55bae2c9-92d0-4fdf-9283-e7ff088bc554',
    11,
    '2018-07-03'), (

    4,
    1,
    12500,
    'GBP',
    'ACCEPTED',
    11500,
    'a482ef89-7d05-4610-98fb-26a86dfbc818',
    12,
    '2018-07-04'), (

    5,
    1,
    37500,
    'GBP',
    'PENDING',
    11500,
    '3e52d8ba-04ff-41ea-aa80-59dd0485fb60',
    12,
    '2018-07-05'), (

    6,
    1,
    -500,
    'AUD',
    'PENDING',
    11000,
    '04582a1c-6e5e-4e3e-867c-5a34a02e25c4',
    13,
    '2018-07-06'), (

    7,
    1,
    77500,
    'USD',
    'PENDING',
    18500,
    '?',
    14,
    '2018-07-07'), (

    8,
    1,
    27500,
    'USD',
    'REJECTED',
    18500,
    '9d25d635-783a-4b25-bb47-c434036deab6',
    14,
    '2018-07-08'), (

    9,
    1,
    -7550,
    'USD',
    'ACCEPTED',
    17250,
    'f5eb8765-3545-48e3-9b73-89045ccdfd3e',
    14,
    '2018-07-09'), (

    10,
    1,
    -4875,
    'EUR',
    'ACCEPTED',
    13500,
    'bd8ded75-bce2-45bc-8365-e42a8310223d',
    15,
    '2018-07-10');