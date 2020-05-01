# EzTrial

ezTrial is a simple software to conduct clinical trials. It's way from finished
and mosty intended as a toy project to play around with.

### setup

use the provided docker compose script to get a database running:
src/main/resources/docker/docker-compose.yml

set this property in application.properties to point to a study odm xml:
eztrial.sample.odm=<path-to-your-study1.xml>

when started, it creates the database objects and imports the sample
study definition an data. then a webserver is fired up and you're good to go.

### build and run
run:
./mvnw spring-boot:run

build the JAR file with 
./mvnw clean package

java -jar target/the.jar

### docker
docker-compose up -d
docker exec -it eztrialpg psql -U postgres
docker logs -f eztrialpg

### Reference Documentation
* [Spring Security](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-security)
* [Spring LDAP](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-ldap)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-webservices)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
