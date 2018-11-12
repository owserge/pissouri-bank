# UI Requirements

### What is this?
Following is a (very) general description of what we need on the UI/UX front. 
We divide requirements into three categories, the **would**, the **should**, and the **could**.

- **Would**: This is a requirement that's not negotiable. Doing something different doesn't make sense.
- **Should**: This is a requirement that is negotiable. Suggestions on alternative approaches welcome.
- **Could**: Not really a requirement, but rather a nice-to-have, complementary feature.

### Assuming Three Screens
- The Customer Profile screen
- The Account Overview screen
- The Transfer (Transaction) Details screen

Requirements for each screen detailed below.

### The Customer Profile Screen

- Could contain an avatar picture (can be a generic one)
- Would contain the customer's first and last name
- Should contain date of birth
- Should contain nationality
- Could contain a country flag next along with nationality
- Should contain registration date (`created_at` field)

### The Account Overview Screen

- Would contain the account number (e.g. "PB100042")
- Would contain the account balance in human readable format with the appropriate currency symbol.
- Should contain the account reference (e.g. "6c7151bc-ed6e-4980-ae80-73ac1d4ea282")
- Would contain bank route information (IBAN, BIC, SWIFT Code, Account Number, Sort Code)
- Would contain bank route address information
- Could contain a country flag along with the address country info
- Would contain the last _X_ (5? 10? up to you) transfers of the account in a list/table format

Each of the transfer entries in the list/table...

- Would contain the transfer amount (positive or negative)
- Would contain the transfer currency
- Should contain an indication of whether the transfer was _INCOMING_ or _OUTGOING_
- Should contain an indication of whether the transfer is _PENDING_, _ACCEPTED_, or _REJECTED_

### The Transfer (Transaction) Details screen

- Would contain the transfer amount (positive or negative)
- Would contain the transfer currency
- Would contain an indication of whether the transfer was _INCOMING_ or _OUTGOING_
- Would contain an indication of whether the transfer is _PENDING_, _ACCEPTED_, or _REJECTED_
- Would contain originator or beneficiary information (IBAN, BIC, SWIFT Code, Account Number, Sort Code)
- Should contain originator or beneficiary address information
- Could contain a country flag along with the originator or beneficiary address country info

Note:
Some fields in the beneficiary/originator information could be empty. The empty fields _would not_ be presented. 



