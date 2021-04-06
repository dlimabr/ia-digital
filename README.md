# ia-digital: Aplicação completa (Backend com Spring-Boot e FrontEnd com Angular) 
- CRUD de Usuário
- Api de Autenticação e Autorização com Spring Security e Spring Session com Redis
- Spring Cloud para gerenciar todas as configurações
- E módulo de Mensageria com RabbitMQ

## Todas as configurações da aplicação estão no GitHub
Configure em ```https://github.com/dlimabr/spring-cloud-config-configuration```


## Módulos da Aplicação:
```
<modules>
		<module>ms-ia-app</module> <!--Aplicação Angular -->
		<module>ms-ia-webapi</module> <!-- API Backend SpringBoot -->
		<module>ia-consumer</module> <!--  Consome mensanges do RabbitMQ -->
		<module>server-config</module> <!-- Servidor de Configurações -->
</modules>
```

## Instruções de Inicialização 
Primeiro módulo que deve ser startardo é o Server-Config, em seguida, proceder com a inicialização dos outros módulos.
