**Proyecto JWT-Auth Spring Boot**
**Descripción General**
Esta aplicación Spring Boot proporciona un servicio de autenticación basado en JSON Web Tokens (JWT). Permite a los usuarios registrarse, iniciar sesión y obtener tokens JWT para acceder a recursos protegidos.

**Tecnologías Utilizadas**
- **Spring Boot**: Framework Java para crear aplicaciones independientes.

- **Spring Security**: Proporciona seguridad a nivel de aplicación, incluyendo autenticación y autorización.

- **JWT**: Estándar para crear tokens seguros que representan una afirmación.

- **Spring Data JPA**: Simplifica el acceso a bases de datos relacionales.

- **MySQL**: Base de datos relacional utilizada para almacenar información de usuarios.

- **Lombok**: Reduce la cantidad de código boilerplate.

- **Mockito**: Framework de pruebas unitarias para simular dependencias.

- **Spring Cloud OpenFeign**: Cliente declarativo para invocar servicios RESTful.

**Estructura del Proyecto y Microservicio **

**Proyecto Padre **
`jwt-auth`

El proyecto `jwt-auth` actúa como un contenedor para múltiples microservicios, estableciendo una base común para todos ellos. Al definirlo como el parent en el archivo `pom.xml` de `msvc-jwt-auth`, estamos heredando:

- **Dependencias**: Todas las bibliotecas y frameworks necesarios para el proyecto, como Spring Boot, Spring Security, y las bibliotecas de JWT.
- **Configuraciones**: Propiedades y configuraciones básicas que se aplicarán a todos los microservicios.
- **Plugins**: Plugins de Maven o Gradle que se utilizarán en la construcción y empaquetado de los microservicios.
En esencia, spring-ecommerce proporciona una estructura unificada y facilita la gestión de dependencias comunes para todos los microservicios dentro del proyecto.

**Microservicio **
`msvc-jwt-auth`
Dentro de `jwt-auth`, `msvc-jwt-auth` es un microservicio independiente que se enfoca en una única responsabilidad: la autenticación de usuarios.

- Autonomía: Este microservicio puede ser desarrollado, desplegado y escalado de forma independiente de otros microservicios.
- Especialización: Se concentra en un solo aspecto de la aplicación (autenticación), lo que facilita el desarrollo, mantenimiento y pruebas.
- Reutilización: Los componentes de autenticación desarrollados en este microservicio pueden ser reutilizados en otros proyectos o microservicios.
La etiqueta `<modules>` en el `pom.xml` de `spring-ecommerce` indica que `msvc-jwt-auth` es un módulo de este proyecto padre. Esto significa que al construir `spring-ecommerce`, también se construirá `msvc-jwt-auth`

**Características Principales**
- **Registro de usuarios**: Permite a los usuarios crear nuevas cuentas.

- **Inicio de sesión**: Autentica a los usuarios y genera tokens JWT.

- **Validación de tokens**: Verifica la validez de los tokens presentados en las solicitudes.

- **Roles de usuario**: Permite definir diferentes roles con distintos permisos.

- **Seguridad**: Protege los recursos de la aplicación utilizando JWT y Spring Security.

**Pre-requisitos**
- Java Development Kit (JDK) 11 o superior
- Maven o Gradle
- Base de datos MySQL

**1. Instalación y Ejecución**
**Clonar el repositorio:**

`git clone https://tu-repositorio.git`

**2. Configurar la base de datos:**
Crear una base de datos con las credenciales especificadas en el archivo de propiedades de la aplicación.
**3. Ejecutar la aplicación:**
`mvn spring-boot:run`

**Pruebas Unitarias**
Se han incluido pruebas unitarias utilizando JUnit y Mockito para garantizar la calidad del código. Para ejecutar las pruebas:

`mvn test`