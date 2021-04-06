# Api de Autenticação e Autorização com Spring Boot, Spring Security, Spring Cloud e PostgreSQL


## Configurar Spring Datasource, JPA, RabbitMQ
Configure em ```https://github.com/dlimabr/spring-cloud-config-configuration/msiawebapi-default.properties```

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
