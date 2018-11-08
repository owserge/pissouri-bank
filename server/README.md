# The Server Side of things

### Account and Transfer Currency

Pissouri bank can only support transfers in the following currencies: 
* Euro, 
* British Pounds, 
* United States Dollar, and 
* Australian Dollar

There should be no accounts or bank transfers in any other currency recorded in the system.

Currencies are always represented with their _alpha 3_ code (i.e. `EUR`, `GBP`, `USD`, `AUD`).

### Transfer Direction

Bank transfers can be INCOMING (account received money) or OUTGOING (account sent money out).
You can identify the transfer direction by looking at the transfer amount - If the amount is negative then the transfer is OUTGOING, if it is positive then the transfer is INCOMING.

### Transfer Status

Bank transfers can be in one of three statuses:

* `PENDING`:  The transfer looks good but has not been processed yet
* `ACCEPTED`: The transfer has been processed and is considered completed
* `REJECTED`: The transfer has been rejected by Pissouri bank and will not be processed

### Account Information Endpoint:

```shell
HTTP GET /v1/account
Content-Type: application/json
```

The endpoint returns a single resource which includes all information for an account.

Example response:
```javascript
{
	"status_code":
	"status_text": "ok",
	"data":
	{
		"id":
		"number":
		"balance": 345780,
		"currency": "EUR"
		"reference": "",
		"registration": {
			"first_name": "John", 
			"last_name": "Cash",
			"dob": "1985-10-25",
			"nationality": "British",
			"address": {
				"street": "1 God Save the Queen Str",
				"city": "London",
				"state": "",
				"postal_code": "EC2700",
				"country": "UK"
			}
		
		},
		"bank_route": {
			"iban": "",
			"bic": "",
			"swift_code": "",
			"account_number": "",
			"sort_code": "",
			"address": {
				"street": "1 Pissouri Ave",
				"city": "Paphos",
				"state": "",
				"postal_code": "5200",
				"country": "Cyprus"
			}
		},
		"created_at": "",
		"updated_at": ""
	}
}
```

### Transfer List Endpoint:

```shell
HTTP GET /v1/account/transfers?type=[TYPE]&status=[STATUS]&page_size=[PAGE_SIZE]&page=[PAGE NUMBER]
Content-Type: application/json
```

The endpoint returns a list of bank transfers for this account.

#### Parameters:
- `type`: Type of bank transfer, options are `IN`, and `OUT`
- `status`: Status of transfer, options are `PENDING`, `ACCEPTED`, `REJECTED`
- `page_size`: The number of elements to retrieve per page
- `page`: Page number
	
All parameters are optional.

In case `page_size` is not provided, the API will return a _maximum of 10 records_.

In case `page` is not provided, the API will return the _first page_ (first 10 records).

The API will always return transfers sorted by the date they were posted, in _descending_ order.

### FX conversion:

If a bank transfer was executed in a currency different than the account currency, then the an FX conversion should have taken place and the system should have recorded it.
In such cases, the transfer object will contain the FX conversion details, as an fx object.

#### Example FX object:
```javascript
	"fx": {
		"amount": 24050,
		"currency": "GBP",
		"rate": 1030457
	}
```
	
### Beneficiary vs Originator:

Incoming bank transfers have an originator, the party that sent the money over to this Pissouri Bank account.
Outgoing bank transfers have are associated with a beneficiary, the party receiving the funds leaving the account.
Incoming bank transfers will include an originator object, while outgoing bank transfers will include a beneficiary object. The objects are identical in structure.

#### Example Beneficiary object:
```javascript
	"beneficiary":
	{
		"iban": "",
		"bic": "",
		"swift_code": "",
		"account_number": "",
		"sort_code": "",
		"address": {
			"street": "7 Tomb of the King Ave",
			"city": "Paphos",
			"state": "",
			"postal_code": "5500",
			"country": "Cyprus"
		}
	}
```

So a bank transfer record could look like the following.
	
#### Example Response:
```javascript
    {
        "status_code": "",
        "status_text": "ok",
        "data": [{
            "id": 37,
            "amount": -34560,
            "currency": "EUR",
            "status": "ACCEPTED",
            "originator":
            {
                "iban": "",
                "bic": "",
                "swift_code": "",
                "account_number": "",
                "sort_code": "",
                "address": {
                    "street": "18 Kato Paphos Sqr",
                    "city": "Paphos",
                    "state": "",
                    "postal_code": "5105",
                    "country": "Cyprus"
                }
            },
            "balance_after": 10670,
            "reference": "",
            "created_at": ""
        }]
    }
```

### IBAN vs SWIFT Code vs Sort Code
You may have noticed that the beneficiary and originator objects contain several fields attempting to describe account information.
In general, you should expect the IBAN and BIC fields to always be populated, but there are some exceptions.

If money was transferred in GBP...
	Field iban will be empty.
	Field bic will be empty.
	Field account_number will be populated with UK account number.
	Field sort_code will be populated with UK sort code.
	Field swift_code will be empty.


If money was transferred in AUD...
	Field iban will be empty.
	Field bic will be populated with the Australian BIC.
	Field account_number will be empty.
	Field sort_code will empty.
	Field swift_code will be populated with an Australian SWIFT Code.
	
Money transfers in any other currency...
	Field iban will be populated with a valid IBAN.
	Field bic will be populated with a valid BIC.
	Field account_number will be empty.
	Field sort_code will be empty.
	Field swift_code will be empty.
	
