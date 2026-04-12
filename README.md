# Backend para Aplicación Web de Viajeros

Si su IDE no incluye un generator para Spring Boot use [Spring Initializr](https://start.spring.io/)

Backend para la aplicación web para viajeros, el frontend está desarrollado en Angular 21.

Este proyecto es desarrollado como parte del curso Soluciones Web y Aplicaciones Distribuidas con NRC 5208, correspondiente al período UPN 2026-1

- ARQUITECTURA: n-capas

## Configuración
- Project: Maven
- Language: Java
- Spring Boot: 4.0.5
- Packaging: jar
- Java: 25
- Archivo de configuración: application.properties

## Recomendaciones
Cuando clone el proyecto revise los siguientes archivos de configuración:
- `application.properties` para validar puertos en los que ejecuta la aplicación, base de datos, usuario y contraseña de la base de datos
- `pom.xml` dependencias y sus versiones que se usan en el proyecto

## Documentación
La API debe evolucionar según el modelo de madurez de Richardson, revise la documentación de [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html) según Martin Fowler

## Dependencias

### Base de datos
Revise el motor de base de datos y la cadena de conexión a su base de datos en el archivo `application.properties` y actualízelo según corresponda. El proyecto está configurado para trabajar con MySQL, para cambiar de motor de base de datos actualice el archivo `pom.xml`

Las dependencia incluida es:
```
    <!-- Conexión a base de datos -->
    <!-- Source: https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.6.0</version>
        <scope>compile</scope>
    </dependency>
```

y en el archivo application.properties agregue la cadena de conexión:
```
    # JPA / Hibernate settings
    spring.jpa.database=mysql
    spring.jpa.show-sql=false
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl.auto=update
    
    # Database connection
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/travelappdb
    spring.datasource.username=your_user
    spring.datasource.password=your_password
```

Para una conexión a postgresql considere la siguiente configuración en pom.xml
```
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
```
Y la configuración de `application.properties`
```
    server.port=9090
    spring.jpa.database=postgresql
    spring.jpa.show-sql=false
    spring.jpa.hibernate.ddl-auto=update
    
    spring.datasource.driver-class-name=org.postgresql.Driver
    #Desde Spring Boot 3.1
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.datasource.url=jdbc:postgresql://localhost:5432/rentalappdb
    spring.datasource.username=your_user
    spring.datasource.password=your_password
```
### JPA
En el archivo archivo `pom.xml` agregue la dependencia
```
    <!-- Source: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>4.0.5</version>
        <scope>compile</scope>
    </dependency>
```