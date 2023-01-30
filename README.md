# payback-coupons-api


## Steps to Run

```
gradle clean build 
docker compose up -d
java -jar build/libs/coupons-api-0.0.1-SNAPSHOT.jar

```

### Sample Requests (Requires Basic Authentication)

1. This request is with member Id. User will get list of valid coupons sorted by valid-until date.

```
curl --location --request GET 'localhost:8091/member-coupons/1' \
--header 'Authorization: Basic cG9pbnRlZTpwYXliYWNr' \
--header 'Cookie: JSESSIONID=2885F2FFDCA4F52643A91438946D4EA4'
```

2. This request is with latitude & longitude. User will get list of Valid coupons sorted by distance. Distance in 
Kilometer and name of the city is added for testing purpose. Here co-ordinates of Munich are provided. 6 coupons are
added with different cities in test DB for testing purpose.

```
curl --location --request GET 'localhost:8091/member-coupons/1?latitude=48.137154&longitude=11.576124' \
--header 'Authorization: Basic cG9pbnRlZTpwYXliYWNr' \
--header 'Cookie: JSESSIONID=2885F2FFDCA4F52643A91438946D4EA4'

```

### Step to run Test cases

```
./gradlew clean build jacocoTestCoverageVerification
```
