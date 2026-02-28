[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/NkrcaSS8)
# API Gateway (Spring Cloud Gateway + Keycloak)
Endpoints:
- `POST /api/login` (sin token)
- `GET /api/users` (con token Keycloak)
- `GET /api/posts` (con token Keycloak)
# Instrucciones
## Variables de entorno
```bash
KEYCLOAK_ISSUER_URI: http://154.38.180.80:8080/realms/group3realm
KEYCLOAK_BASE_URL: http://154.38.180.80:8080
KEYCLOAK_REALM: group3realm
KEYCLOAK_CLIENT_ID: group3app
KEYCLOAK_CLIENT_SECRET: pS9x84Qm0FkOJVrueg5OTtNYCWCAGtEp
```
## Credenciales de prueba login
```bash
username: "paul"
password: "123"
```
## Docker
Iniciar mediante docker compose
```bash
docker compose up
```
## Curl
### Login (Post)
URL
```bash
http://localhost:8080/api/login
```
Body
```bash
{
    "username": "paul",
    "password": "123"
}
```
### Users (Get) [Token]
URL
```bash
http://localhost:8080/api/users
```
### Posts (Get) [Token]
URL
```bash
http://localhost:8080/api/posts
```