Gym Management System
Este proyecto es una aplicación de gestión de gimnasios diseñada para que el administrador pueda gestionar clientes, entrenadores, clases y membresías. La aplicación se divide en dos partes: el backend (API RESTful) y el frontend (interfaz de usuario).


Descripción
El backend es una API RESTful desarrollada con Spring Boot. Permite gestionar:

Clientes: Registro, edición, eliminación y visualización.
Entrenadores: Registro, asignación a clases, edición y eliminación.
Clases de entrenamiento: Creación, actualización, eliminación y visualización.
Membresías: Gestión y actualización automática del estado (por ejemplo, cambiar de ACTIVE a EXPIRED) mediante tareas programadas, y envío de notificaciones (por email y WhatsApp) cuando las cuotas vencen.


Tecnologías utilizadas
Spring Boot (con Java)
Spring Data JPA (Hibernate)
JWT para autenticación
Base de datos: MySQL o PostgreSQL (configurable)
Tareas programadas: @Scheduled (con @EnableScheduling)

Funcionalidades principales
Gestión de clientes, entrenadores y clases: CRUD completo.
Actualización automática de membresías vencidas: Un job diario revisa y actualiza el estado de las membresías.
Reportes: Endpoint para obtener la lista de clientes con membresías vencidas para facilitar la gestión.
