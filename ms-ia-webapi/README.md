# Api de Autenticação e Autorização com Spring Boot, Spring Security e PostgreSQL


## Configurar Spring Datasource, JPA, RabbitMQ
Abra `src/main/resources/application.properties`

```
spring.datasource.url= jdbc:postgresql://localhost:5432/ms-security
spring.datasource.username= postgres
spring.datasource.password= 123

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
ia.app.jwtSecret= iaAppSecretKey
ia.app.jwtExpirationMs= 86400000
```

## Comando para startar o spring-boot
```
mvn spring-boot:run
```

## Inserir os seguintes registros no banco
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
