# Api de Autenticação e Autorização com Spring Boot, Spring Security, Spring Cloud, Spring Session com Redis e Mensageria com RabbitMQ


## Todas as configurações da aplicação estão no GitHub
Configure em ```https://github.com/dlimabr/spring-cloud-config-configuration/msiawebapi-default.properties```

## Comando para startar o spring-boot
```
mvn spring-boot:run
```
## Necessário ter um servidor RabbitMQ
https://www.rabbitmq.com/download.html

## Necessário ter um servidor Redis
https://github.com/microsoftarchive/redis/releases/

## Necessário instalar o Postgress
https://www.postgresql.org/download/


## Após startar a aplicação, deve-se inserir os seguintes registros no banco:
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
