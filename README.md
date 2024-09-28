how to run the app

1- run this commands:
- docker build -t currencyexchange .
- docker run -p 8081:8081 currencyexchange:latest

2- call auth api from postman to generate token
url POST: http://localhost:8081/api/auth
request body: 
{
"username": "admin",
"password": "admin"
}

3- copy the token then open postman new tap then call 
calculate api then select authorization tap 
and select type bearer token then past the token

url POST: http://localhost:8081/api/calculate
request body:
{
"items": [
{
"itemId": 0,
"itemName": "test"
}
],
"totalAmount": 500,
"userType": "employee",
"originalCurrency": "AED",
"targetCurrency": "USD",
"customerTenure": 1,
"grocery": false
}

notes:
- maven version 3.9.5
- JDK 21
- spring boot 3.3.4
- integrate with Open
  Exchange Rates