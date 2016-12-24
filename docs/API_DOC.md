#Hedwig Web API

##SMS
###Push Sms
```http
POST /sms
```
* _Request_

```json
{
"title":"테스트",
"recevier_number":"010-1234-5678",
"application_name":"Pandora",
"contents":"테스트 문자 발송",
"callback_url":"http://www.pandora.com/result"
}
```

* _Response_

```json
SUCCESS { "code":"200", "message":"OK" } 
```
```json
FAIL { "code":"500", "message":"Server Internal Error"}
```

##USER
###Join user
```http
POST /users
```
* _Request_

```json
{
"email":"yjs930915@gmail.com",
"password":"dfpieqEYNfiohbe",
"phone_number":"01012345678",
}
```

* _Response_

```json
SUCCESS { "code":"200", "message":"OK" } 
```
```json
FAIL { "code":"500", "message":"Server Internal Error"}
```

###Login user
```http
POST /users
```
* _Request_

```json
{
"email":"yjs930915@gmail.com",
"password":"dfpieqEYNfiohbe"
}
```

* _Response_

```json
SUCCESS { "code":"200", "message":"OK" } 
```
```json
FAIL { "code":"501", "message":"Incorrect Password"}
```
