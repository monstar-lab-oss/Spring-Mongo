# mongoDB-java-poc
Provides Sample of How we can integrate MongoDB into a Java project (Spring Boot).
The project can serve as a POC.

## Requirements
* JDK 17
* Any IDE with [lombok](https://projectlombok.org/) plugin installed

## How to code
Import as a java project in an IDE of your choice.

## Working locally
### How to run the app (local with mvn commands)
Run `mvn clean install`. This will generate the appropriate jar, that will be run later on.

Before running the app set the following env variables (take advantage of the IDEA run configuration)

`DATABASE_URI=`

`DATABASE_NAME=`

Run `mvn spring-boot:run -f pom.xml`


