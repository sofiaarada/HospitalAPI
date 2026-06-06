# Hospital San Gabriel — API REST

API REST para gestión de pacientes desarrollada con Spring Boot, MySQL, JWT y Swagger.

## Tecnologías utilizadas
- Java 21
- Spring Boot 3.5
- Spring Security + JWT
- Spring Data JPA
- MySQL 8
- Swagger / OpenAPI
- Maven

## Requisitos previos
- Java 21 instalado
- MySQL corriendo en el puerto 3306
- Maven instalado

## Configuración de la base de datos
Crear la base de datos en MySQL:
```sql
CREATE DATABASE hospital_db;
```

## Configuración del proyecto
Editar el archivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3300/hospital_db
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
```

## Cómo ejecutar el proyecto
1. Clonar el repositorio
```bash
git clone https://github.com/TU_USUARIO/hospital-api.git
```
2. Entrar a la carpeta
```bash
cd hospital-api
```
3. Ejecutar con Maven
```bash
mvn spring-boot:run
```

## Endpoints disponibles

### Autenticación
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /auth/register | Registrar usuario |
| POST | /auth/login | Iniciar sesión y obtener token |

### Pacientes (requieren token JWT)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/pacientes | Crear paciente |
| GET | /api/pacientes | Listar pacientes |
| GET | /api/pacientes/{id} | Buscar por ID |
| PUT | /api/pacientes/{id} | Actualizar paciente |
| DELETE | /api/pacientes/{id} | Eliminar paciente |

## Documentación Swagger
Con la app corriendo, abrir en el navegador:
