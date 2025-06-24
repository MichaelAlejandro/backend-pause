# PA.U.S.E.

**PA.U.S.E.** es una aplicación de bienestar personal que utiliza una mascota virtual para motivar al usuario a tomar micro-pausas activas, realizar repasos de conceptos, y mejorar su estado mental durante la jornada.

Este repositorio corresponde al **backend** del sistema, desarrollado en **Kotlin + Spring Boot**, con persistencia en **PostgreSQL** dentro de contenedores Docker.

---

## Tecnologías utilizadas

- Kotlin + Spring Boot
- PostgreSQL 
- Mockito
- Postman para pruebas de API REST

---

## Requisitos previos

- Java 21
- Docker + Docker Compose
- Postman 
- Gradle 

---

## Endpoints principales

| Recurso     | Método  | Ruta                         | Descripción                            |
|-------------|---------|------------------------------|----------------------------------------|
| **Usuarios**| GET     | `/api/pause/users`           | Obtener todos los usuarios             |
|             | GET     | `/api/pause/users/{id}`      | Obtener un usuario por ID              |
|             | POST    | `/api/pause/users`           | Crear un nuevo usuario                 |
|             | PUT     | `/api/pause/users/{id}`      | Actualizar un usuario existente        |
|             | DELETE  | `/api/pause/users/{id}`      | Eliminar un usuario                    |
| **Mascotas**| GET     | `/api/pause/pets`            | Obtener todas las mascotas             |
|             | GET     | `/api/pause/pets/{id}`       | Obtener una mascota por ID             |
|             | POST    | `/api/pause/pets`            | Crear una mascota vinculada a usuario  |
|             | PUT     | `/api/pause/pets/{id}`       | Actualizar una mascota                 |
|             | DELETE  | `/api/pause/pets/{id}`       | Eliminar una mascota                   |
| **Pausas**  | GET     | `/api/pause/pauses`          | Obtener todas las pausas               |
|             | GET     | `/api/pause/pauses/{id}`     | Obtener una pausa por ID               |
|             | POST    | `/api/pause/pauses`          | Registrar una pausa nueva              |
|             | DELETE  | `/api/pause/pauses/{id}`     | Eliminar una pausa                     |
| **Repasos** | GET     | `/api/pause/reviews`         | Obtener todos los repasos              |
|             | GET     | `/api/pause/reviews/{id}`    | Obtener un repaso por ID               |
|             | POST    | `/api/pause/reviews`         | Crear un nuevo repaso                  |
|             | DELETE  | `/api/pause/reviews/{id}`    | Eliminar un repaso                     |


---

## Levantar la base de datos (PostgreSQL)

```bash
docker-compose up -d
```

Esto iniciará un contenedor PostgreSQL en el puerto `2323`.

---


## Pruebas con Postman

Dentro del proyecto se incluye la colección:

```
pause_postman_collection.json
```

Puedes importarla en Postman para probar todos los endpoints del backend.

---
