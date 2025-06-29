# Notas API

Una API RESTful sencilla para gestionar notas personales, desarrollada con Java y Spring Boot. Este proyecto forma parte de mi portafolio como práctica de backend y arquitectura en capas.

##  -Tecnologías usadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database (modo dev)
- SpringDoc OpenAPI (Swagger UI)
- Maven

## -Funcionalidades

- CRUD completo de notas (crear, leer, actualizar, eliminar)
- Validación de datos
- Documentación automática con Swagger UI
- Arquitectura por capas: Controller, Service, DTO, Repository
- Relación básica con entidad

##  Cómo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/MAGZ014/notas-api.git

# Entrar al proyecto
cd notas-api

# Ejecutar (si tienes Maven)
./mvnw spring-boot:run
```
## Documentación de la API

Esta API cuenta con documentación automática generada con **Swagger UI** a través de SpringDoc OpenAPI.

Una vez que la aplicación esté en ejecución, puedes acceder a la documentación desde:
http://localhost:8080/api/swagger-ui/index.html

También puedes ver el JSON de especificaciones OpenAPI en: http://localhost:8080/api/v3/api-docs



## Configuración

Copia el archivo `application.example.yml` como `application.yml` y ajusta tus credenciales locales.
