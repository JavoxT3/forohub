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
> ⚠️ Importante:
> En el login debes usar el usuario registrado en la base de datos.
> La contraseña se envía en texto plano en el JSON.
> La encriptación con BCrypt ocurre internamente en el servidor.

Si las credenciales son correctas, la API devuelve:

```
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

<img width="1468" height="843" alt="Captura de pantalla 2026-02-12 000243" src="https://github.com/user-attachments/assets/efc95a60-0602-4b63-88df-77e2a5b6408f" />

---

### 🔹 Uso del Token

Para acceder a los endpoints protegidos debes enviar el token en el Auth:

Authorization: Bearer TU_TOKEN_AQUI

<img width="723" height="492" alt="w" src="https://github.com/user-attachments/assets/e721e8a0-3bed-4236-ab14-63e33eb134ce" />


---

### 📚 Endpoints de Tópicos

Todos los endpoints requieren un token JWT válido.
El único endpoint público es `/login`.

Si el token es inválido o no se envía, la API responderá con:
- `403 Forbidden`

Si el token es válido:
- `200 OK`

---
-🔹 Crear tópico

POST /topicos


<img width="731" height="450" alt="Captura de pantalla 2026-02-12 000401" src="https://github.com/user-attachments/assets/b6af16d3-4618-444a-aea2-f82ca7f6ae30" />

---
-🔹 Listar tópicos

GET /topicos


<img width="1462" height="826" alt="Captura de pantalla 2026-02-12 000427" src="https://github.com/user-attachments/assets/cb0456b7-073a-4058-91d9-7abbf98daded" />

---
-🔹 Detallar tópico

GET /topicos/{id}

<img width="1465" height="571" alt="Captura de pantalla 2026-02-12 000448" src="https://github.com/user-attachments/assets/48646b22-a8db-4e44-938c-391a6f963c7a" />

---
-🔹 Actualizar tópico

PUT /topicos/{id}

<img width="1465" height="698" alt="Captura de pantalla 2026-02-12 000339" src="https://github.com/user-attachments/assets/d5c8c908-38d7-4a98-b388-0f2f59676fb5" />

---
-🔹 Eliminar tópico

DELETE /topicos/{id}

<img width="723" height="534" alt="Captura de pantalla 2026-02-12 000318" src="https://github.com/user-attachments/assets/5680f27c-4c4f-42ae-90b2-e5039557a8b2" />


---

### ⚙ Configuración del Proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO
```
---

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

<img width="1256" height="548" alt="image" src="https://github.com/user-attachments/assets/6a0a60aa-09eb-47aa-82a3-aba85fdf05ef" />

El valor configurado en:

```
jwt:
  secret: 123456
  expiration: 3600000
```

corresponde únicamente a la clave interna utilizada para firmar los tokens JWT y no está relacionado con la contraseña del usuario.

---

3️⃣ Crear usuario en la base de datos

El proyecto incluye un usuario de prueba para facilitar la validación del sistema.

 login: admin, 
 clave: 123456

Sin embargo, es posible utilizar cualquier otro usuario y contraseña.

Para ello existen dos opciones:

### Opción 1 — Insertar un usuario manualmente en la base de datos

Se debe registrar un nuevo usuario en la tabla `usuarios`, asegurándose de que la contraseña esté encriptada con **BCrypt**.

Ejemplo:

```sql
INSERT INTO usuarios (login, clave)
VALUES ('nuevo_usuario', 'CLAVE_ENCRIPTADA_CON_BCRYPT');

```
Ejemplo:

```
INSERT INTO usuarios (login, clave)
VALUES (
  'admin',
  '$2a$10$T/QPzlpltIwhqL6.wvy62e6mNssgB5IvrWcXIdcxT0nYIj0jiO2l6'
);

```
⚠️ Importante: No se debe guardar la contraseña en texto plano.
Debe estar encriptada usando BCryptPasswordEncoder.

Opción 2 — Modificar el usuario existente

También se puede actualizar el usuario de prueba directamente en la base de datos cambiando su login o contraseña (siempre encriptada).

La base de datos utilizada en este proyecto es MySQL.
Sin embargo, puede adaptarse fácilmente a cualquier motor compatible con JPA/Hibernate ajustando la configuración del `application.yml`.


<img width="1105" height="568" alt="image" src="https://github.com/user-attachments/assets/8dddebbf-f97f-46e5-8baa-77693ebb459d" />

---

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
