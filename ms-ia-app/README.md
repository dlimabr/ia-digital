# AngularApp 8 - Autenticação baseada em JWT – Token

Principais serviços integrados na aplicação:
- POST `api/auth/signup` para Cadastro de Usuário
- POST `api/auth/signin` para Login
- POST `api/email` para enviar mensagem para fila do RabbitMQ
- GET `api/users` para recuperar usuários
- Get `api/users/principal` para recuperar usuário da sessão
- POST `api/auth/invalidate/session` para invalidar sessão

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
