# PicPay Back End challenger

> This an API test for picpay
>
> Only COMMON can send transactions

## Technologies:

![java](https://img.shields.io/badge/java-17-blue)
![spring](https://img.shields.io/badge/spring-3.1-green)

## Getting starter

```bash
mvn clean install
```

AND

```bash
mvn spring-boot:run
```

#### Open on [localhost:8080](http://localhos:8080)


### Routes:
#### User:

```/user```
> POST

```json
{
  "firstname": "user",
  "lastname": "john",
  "document": "999.999.999-99",
  "balance": 15.6,
  "email": "user@email.com",
  "password": "123",
  "userType": "COMMON"
}
```

```/user```
> GET

return:

```json
[
  {
    "firstname": "user",
    "lastname": "john",
    "document": "999.999.999-99",
    "balance": 15.6,
    "email": "user@email.com",
    "userType": "COMMON"
  }
]
```

```/transactions```
> POST

{
  "value": 78.6,
  "senderId": 1,
  "receiverId": 2
}
