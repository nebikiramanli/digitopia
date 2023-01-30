# digitopia

Postman API Example

```

{
	"info": {
		"_postman_id": "1133f850-3dfe-4e7d-a64f-c1d205f9f84d",
		"name": "digi",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "17886301"
	},
	"item": [
		{
			"name": "ByName",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/users/name=Nebi",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"name=Nebi"
					]
				}
			},
			"response": []
		},
		{
			"name": "Create New User",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"fullName\": \"Nebi Kıramanli 222\",\r\n    \"email\": \"nebikiramanliiii@gmail.com\",\r\n    \"normalizedName\": \"nebikiramanli55\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/users/create",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"create"
					]
				}
			},
			"response": []
		},
		{
			"name": "User  By UUID",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/users/2",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"2"
					]
				}
			},
			"response": []
		}
	]
}
```
