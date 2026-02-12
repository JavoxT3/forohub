# 📌 ForoHub API

ForoHub es una API REST desarrollada con **Spring Boot 3** que permite gestionar tópicos de un foro.  
Incluye autenticación con **Spring Security** y autorización mediante **JWT (JSON Web Token)**.

---

## 🚀 Funcionalidades

- ✅ Crear tópicos
- ✅ Listar tópicos
- ✅ Consultar un tópico por ID
- ✅ Actualizar tópicos
- ✅ Eliminar tópicos
- ✅ Autenticación segura mediante login
- ✅ Protección de endpoints con JWT

---

## 🛠 Tecnologías utilizadas

- Java 17+
- Spring Boot 3
- Spring Security
- JWT (Auth0 Java JWT)
- MySQL
- JPA / Hibernate
- Maven

---

## 🔐 Autenticación

La API utiliza autenticación basada en JWT.

### 🔹 Login

**Endpoint:**

POST http://localhost:8080/login

**Body (JSON):**

```json
{
  "login": "admin",
  "clave": "123456"
}
```

Si las credenciales son correctas, la API devuelve:
```
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
---

### 🔹 Uso del Token

Para acceder a los endpoints protegidos debes enviar el token en el header:

Authorization: Bearer TU_TOKEN_AQUI

---

### 📚 Endpoints de Tópicos

Todos requieren token JWT.

-🔹 Crear tópico

POST /topicos

-🔹 Listar tópicos

GET /topicos

-🔹 Detallar tópico

GET /topicos/{id}

-🔹 Actualizar tópico

PUT /topicos/{id}

-🔹 Eliminar tópico

DELETE /topicos/{id}

---

### ⚙ Configuración del Proyecto

1️⃣ Clonar el repositorio
git clone URL_DEL_REPOSITORIO

2️⃣ Configurar Base de Datos

Editar application.yml:

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/forohub
    username: root
    password: TU_PASSWORD

jwt:
  secret: 123456
  expiration: 3600000

```

3️⃣ Crear usuario en la base de datos

La contraseña debe estar encriptada con BCrypt.

Ejemplo:

```
INSERT INTO usuarios (login, clave)
VALUES (
  'admin',
  '$2a$10$T/QPzlpltIwhqL6.wvy62e6mNssgB5IvrWcXIdcxT0nYIj0jiO2l6'
);

```

4️⃣ Ejecutar el proyecto

Desde el IDE o con:
```
mvn spring-boot:run
```

---

### 🔒 Seguridad implementada

🔐 Autenticación con Spring Security

🔑 Passwords encriptadas con BCrypt

🪪 Token JWT firmado con HMAC256

🛡 Filtro personalizado para validar token en cada request

🚫 Protección total de endpoints excepto /login

---

### 📌 Estado del Proyecto

✔ Autenticación implementada
✔ Generación y validación de JWT
✔ Filtro de autorización
✔ CRUD completo de tópicos
✔ Manejo de errores HTTP

---

### 👨‍💻 Autor

Jhonatan Montiel
Proyecto desarrollado como parte del Challenge de Alura Latam.
