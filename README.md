# Getting Started

### Microserviço utilizando o framework Spring Boot, que recupera o resumo de todos os repositórios do GitHub para um determinado usuário deste serviço.

# O endpoint de listagem protegido por Jwt authentication, usando Bearer Token;

# Endpoint para autenticação de usuário
	
Para autenticação, está disponível o endpoint /auth, que espera receber um POST com os dados do usuário no corpo, em formato JSON, conforme exemplo abaixo:

URL: https://microservico.herokuapp.com/auth

{
"username": "admin",
"password": "12345"
 }

## Endpoint que recupera o resumo de todos os repositórios do GitHub para um determinado usuário deste serviço

https://microservico.herokuapp.com/repositorio/wendercorrea


## Documentação
Disponível na URL https://microservico.herokuapp.com/swagger-ui.html



### Deploy realizado no Heroku

https://microservico.herokuapp.com/



