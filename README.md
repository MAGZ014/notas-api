# Notas API

Una API RESTful sencilla para gestionar notas personales, desarrollada con Java y Spring Boot. Este proyecto forma parte de mi portafolio como práctica de backend y arquitectura en capas.

##  -Tecnologías usadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database (modo dev)
- Maven

## -Funcionalidades

- CRUD completo de notas (crear, leer, actualizar, eliminar)
- Validación de datos
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