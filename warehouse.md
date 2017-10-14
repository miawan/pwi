### All Active w.h
### URL	: http://localhost:8081/pwi/activeWarehouses
### Sample Request
```
{
	"userId": null,
	"sessionId": null,
	"errorCode": 1,
	"errorMessage": "SUCCESS",
	"responseTime": 680,
	"recordCount": 2,
	"warehoses": [
		{
			"id": 1,
			"name": "test1",
			"description": "test warehouse 1",
			"isActive": true,
			"address": {
				"id": null,
				"address1": null,
				"address2": null,
				"city": null,
				"state": null,
				"zipCode": null,
				"countryIdFk": 0,
				"isPrimary": null,
				"active": null,
				"createdBy": null,
				"createdAt": null,
				"modifiedBy": null,
				"modifiedAt": null,
				"country": null,
				"company": null
			}
		},
		{
			"id": 2,
			"name": "two Test",
			"description": "test warehouse2",
			"isActive": true,
			"address": {
				"id": null,
				"address1": null,
				"address2": null,
				"city": null,
				"state": null,
				"zipCode": null,
				"countryIdFk": 0,
				"isPrimary": null,
				"active": null,
				"createdBy": null,
				"createdAt": null,
				"modifiedBy": null,
				"modifiedAt": null,
				"country": null,
				"company": null
			}
		}
	]
}

```

### Update W.H
### URL http://localhost:8081/pwi/warehouse
### Sample Request
```
{
	"warehouseId": 1
}
```

### Response
```
{
	"userId": null,
	"sessionId": null,
	"errorCode": 0,
	"errorMessage": null,
	"responseTime": 614,
	"recordCount": 0,
	"warehouse": {
		"id": 1,
		"name": "test1",
		"description": "test warehouse 1",
		"isActive": true,
		"address": {
			"id": null,
			"address1": null,
			"address2": null,
			"city": null,
			"state": null,
			"zipCode": null,
			"countryIdFk": 0,
			"isPrimary": null,
			"active": null,
			"createdBy": null,
			"createdAt": null,
			"modifiedBy": null,
			"modifiedAt": null,
			"country": null,
			"company": null
		}
	}
}
```
### Save W.H
### URL: http://localhost:8081/pwi/saveWarehouse
### Sample Request
```
{
	"name": "WarehouseA",
	"description": "Oceana Dump site",
	"address": {
		"address1": "address1",
		"city": "SEA",
		"zipCode": "090078601",
		"country":{
			"id":1
		}
	}
}
```
### Response
```
{
	"userId": null,
	"sessionId": null,
	"errorCode": 0,
	"errorMessage": null,
	"responseTime": 2131,
	"recordCount": 0,
	"warehouse": {
		"id": 4,
		"name": "WarehouseA",
		"description": "Oceana Dump site",
		"isActive": null,
		"address": {
			"id": null,
			"address1": "address1",
			"address2": null,
			"city": "SEA",
			"state": null,
			"zipCode": "090078601",
			"countryIdFk": 0,
			"isPrimary": null,
			"active": null,
			"createdBy": null,
			"createdAt": null,
			"modifiedBy": null,
			"modifiedAt": null,
			"country": {
				"id": 1,
				"name": null,
				"code": null,
				"addresses": []
			},
			"company": null
		}
	}
}
```
### Delete W.H
### URL :		http://localhost:8081/pwi/deleteWarehouse
### Sample Request
```
{"id":"4"}
```
### Sample Response
```
{
	"userId": null,
	"sessionId": null,
	"errorCode": 1,
	"errorMessage": "SUCCESS",
	"responseTime": 3734,
	"recordCount": 1
}
```
### Get All Available sizes of a product
### URL	:	http://localhost:8081/pwi/availableSize
### Sample Request
```
{
	"productId":"1",
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
	"responseTime": 3102,
	"recordCount": 3,
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
		"productSizes": null,
		"name": "Hair Repair",
		"description": "Hair Repair cream, recreate hair",
		"type": "CREAM",
		"isActive": true,
		"createdAt": 1507719291000,
		"createdBy": null,
		"modifiedAt": 1507719293000,
		"modifiedBy": null
	},
	"availableSize": [
		{
			"id": 5,
			"size": "10"
		},
		{
			"id": 6,
			"size": "20"
		},
		{
			"id": 7,
			"size": "30"
		}
	]
}
```
