# EzTrial

Perform clinical trials with ease.

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Security](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-security)
* [Spring LDAP](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-ldap)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-webservices)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

run:
./mvnw spring-boot:run

build the JAR file with 
./mvnw clean package

java -jar target/gs-accessing-data-jpa-0.1.0.jar

docker-compose up -d
docker exec -it eztrialpg psql -U postgres
docker logs -f eztrialpg

