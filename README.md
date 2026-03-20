# API de Usuários de Teste

API desenvolvida em Java com Spring Boot para o teste técnico, com arquitetura em camadas inspirada em DDD, autenticação básica, documentação Swagger e integração com banco SQL Server.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Swagger / OpenAPI
- SQL Server
- Maven

## Estrutura do projeto

O projeto foi organizado em camadas para manter a separação de responsabilidades:

- `api` → controllers
- `application` → services, DTOs e mappers
- `domain` → entidades
- `infrastructure` → repositórios
- `config` → segurança, CORS e Swagger

## Funcionalidades

- Cadastro de usuário
- Busca de usuário por ID
- Listagem de usuários
- Listagem por entidade mapeada
- Listagem por stored procedure
- Autenticação básica
- Swagger para documentação e testes
- CORS para integração com frontend Angular

## Principais endpoints

### Cadastrar usuário
`POST /usuarios`

### Buscar por ID
`GET /usuarios/{id}`

### Listar todos
`GET /usuarios`

### Buscar por entidade
`GET /usuarios/entidade/{origem}`

### Buscar por procedure
`GET /usuarios/procedure/{origem}`

## Autenticação

A API utiliza autenticação básica.

**Usuário de teste:**
- usuário: `admin`
- senha: `123`

## Swagger

Ao subir a aplicação, acesse:

`http://localhost:8080/swagger-ui.html`
