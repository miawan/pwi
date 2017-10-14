### Save product
### URL http://localhost:8081/pwi/saveProduct
### sample request:
```
  {
			"name":"Hair Repair",
			"description":"Hair Repair cream, recreate hair",
			"type":"CREAM",
			"size":"250",
			"brand":{
				"id":"1"
			}
			
	}
```
### Sample Response
```
{
			"userId": null,
			"sessionId": null,
			"errorCode": 0,
			"errorMessage": null,
			"responseTime": 92,
			"recordCount": 0,
			"product": {
				"id": 6,
				"brand": {
					"id": 1,
					"company": null,
					"name": null,
					"description": null,
					"createdAt": null,
					"createdBy": null,
					"modifiedAt": null,
					"modifiedBy": null,
					"products": []
				},
				"name": "Hair Repair",
				"description": "Hair Repair cream, recreate hair",
				"type": "CREAM",
				"size": "250",
				"isActive": null,
				"createdAt": 1507700930179,
				"createdBy": null,
				"modifiedAt": null,
				"modifiedBy": null
			}
		}	
```

### Get all active products available
### URL http://localhost:8081/pwi/activeProducts
### Sample Request
```
{ 
  "brandId":"1",				
	"warehouseId":"1"
}	
```
### Sample Response
```
{
			"userId": null,
			"sessionId": null,
			"errorCode": 1,
			"errorMessage": "SUCCESS",
			"responseTime": 30,
			"recordCount": 2,
			"products": [
				{
					"id": 6,
					"brand": {
						"id": 1,
						"company": {
							"id": null,
							"addresses": [],
							"name": null,
							"description": null,
							"createdAt": null,
							"createdBy": null,
							"modifiedAt": null,
							"modifiedBy": null,
							"brands": []
						},
						"name": "TEST_NAME",
						"description": "TEST_DESCRIPTION",
						"createdAt": 1507198905000,
						"createdBy": 1,
						"modifiedAt": null,
						"modifiedBy": null,
						"products": []
					},
					"name": "Hair Repair",
					"description": "Hair Repair cream, recreate hair",
					"type": "CREAM",
					"size": "250",
					"isActive": true,
					"createdAt": 1507700930000,
					"createdBy": null,
					"modifiedAt": null,
					"modifiedBy": null
				}
			]
		}
```


### Get Uniqu product in warehouse
### URL : http://localhost:8081/pwi/product
### Sample Reuest
```
{
			"productId": "6",
			"warehouseId": "1"
		}	
```
### Sample Response

```
{
	"userId": null,
	"sessionId": null,
	"errorCode": 0,
	"errorMessage": null,
	"responseTime": 5345,
	"recordCount": 0,
	"product": {
		"id": 6,
		"brand": {
			"id": 1,
			"company": {
				"id": null,
				"addresses": [],
				"name": null,
				"description": null,
				"createdAt": null,
				"createdBy": null,
				"modifiedAt": null,
				"modifiedBy": null,
				"brands": []
			},
			"name": "TEST_NAME",
			"description": "TEST_DESCRIPTION",
			"createdAt": 1507198905000,
			"createdBy": 1,
			"modifiedAt": null,
			"modifiedBy": null,
			"products": []
		},
		"name": "Hair Repair",
		"description": "Hair Repair cream, recreate hair",
		"type": "CREAM",
		"size": "250",
		"isActive": true,
		"createdAt": 1507700930000,
		"createdBy": null,
		"modifiedAt": null,
		"modifiedBy": null
	}
}
```

### Delete
### URL: http://localhost:8081/pwi/deleteProduct
### Sample Request
```
{
			"productId": "6",
			"warehouseId": "1"
		}	
```

### Sample REsponse
```
response:
		{
	"userId": null,
	"sessionId": null,
	"errorCode": 1,
	"errorMessage": "SUCCESS",
	"responseTime": 298,
	"recordCount": 1,
	"product": null
}
```
### Update Quantity
### URL  :	http://localhost:8081/pwi/setQuantity
### Sample Request
```
{
	"productId": "6",
	"allWarehouses":"false",
	"warehouseids": [
		1
	],
	"inStock":"20000",
	"availableQuantity":"2950",
	"inTransit":"250",
	"moq":"200",
	"qpb":"3",
	"reOrderPoint":"150"
	
}
```

### View product quantity
### URL	:http://localhost:8081/pwi/itemDetails
### Sample Rquest
```
{
	"productId":"1",
	"warehouseids": [
		1,2
	]
}
```
### Response
```
{
	"userId": null,
	"sessionId": null,
	"errorCode": 0,
	"errorMessage": null,
	"responseTime": 35,
	"recordCount": 0,
	"product": {
		"id": 1,
		"brand": {
			"id": 1,
			"company": {
				"id": null,
				"addresses": [],
				"name": null,
				"description": null,
				"createdAt": null,
				"createdBy": null,
				"modifiedAt": null,
				"modifiedBy": null,
				"brands": []
			},
			"name": "TEST_NAME",
			"description": "TEST_DESCRIPTION",
			"createdAt": 1507198905000,
			"createdBy": 1,
			"modifiedAt": null,
			"modifiedBy": null,
			"products": []
		},
		"name": "franklin",
		"description": "test product",
		"type": "liquid",
		"size": "10",
		"isActive": true,
		"createdAt": 1507634631000,
		"createdBy": 1,
		"modifiedAt": null,
		"modifiedBy": null
	},
	"warehouses": [
		{
			"inStock": 10000,
			"availableQuantity": 1950,
			"inTransit": 200,
			"moq": 100,
			"qpb": 2,
			"reOrderPoint": 100,
			"id": 3,
			"name": "test1",
			"description": "test warehouse 1",
			"isActive": true,
			"address": {
				"id": 1,
				"address1": "jkh",
				"address2": "kj",
				"city": "kjlkj",
				"state": null,
				"zipCode": null,
				"countryIdFk": 0,
				"isPrimary": null,
				"active": true,
				"createdBy": null,
				"createdAt": null,
				"modifiedBy": null,
				"modifiedAt": null,
				"country": {
					"id": 1,
					"name": "Pakistan",
					"code": "92",
					"addresses": []
				},
				"company": null
			}
		}
	]
}
```
