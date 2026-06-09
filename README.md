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

#### 1. MySQL

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
    spring.jpa.hibernate.ddl-auto=update
    
    # Database connection
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    # Desde Spring Boot 3.1
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    spring.datasource.url=jdbc:mysql://localhost:3306/travelappdb
    spring.datasource.username=your_user
    spring.datasource.password=your_password
```

#### 2. PostgreSQL

Para una conexión a postgresql considere la siguiente configuración en `pom.xml`
```
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
```

  o tambien opte por

```
    <!-- Source: https://mvnrepository.com/artifact/org.postgresql/postgresql -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.10</version>
        <scope>compile</scope>
    </dependency>
```

Y la configuración de `application.properties`

```
    # JPA / Hibernate settings
    spring.jpa.database=postgresql
    spring.jpa.show-sql=false
    spring.jpa.hibernate.ddl-auto=update
    
    spring.datasource.driver-class-name=org.postgresql.Driver
    #Desde Spring Boot 3.1
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.datasource.url=jdbc:postgresql://localhost:5432/travelappdb
    spring.datasource.username=your_user
    spring.datasource.password=your_password
```
En la mayoría de los casos, no es necesario incluir esta propiedad `spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect`. Hibernate 6 puede deducir el dialecto correcto basándose exclusivamente en la spring.datasource.url

#### 3. MariaDB

Opte por usar la configuración de MariaDB si es que la configuración de MySQL le genera error, estos errores se debe a actualizaciones recientes de MySQL
Para una conexión a MariaDB considere la siguiente configuración en `pom.xml`

```
    <!-- Source: https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->
        <dependency>
            <groupId>org.mariadb.jdbc</groupId>
            <artifactId>mariadb-java-client</artifactId>
            <version>3.5.8</version>
            <scope>compile</scope>
        </dependency>
```

Y la configuración de `application.properties`

```
    # JPA / Hibernate settings
    spring.jpa.database=mysql
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    
    # Database connection
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    spring.datasource.url=jdbc:mariadb://localhost:3306/travelappdb
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
## DTO

### ModelMapper
Revise la documentación de [modelMapper](https://modelmapper.org/getting-started/)

En el archivo archivo `pom.xml` agregue la dependencia
```
        <!-- Source: https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>3.2.6</version>
            <scope>compile</scope>
        </dependency>
```

Tambien puede optar por usar [MapStruct](https://mapstruct.org/)

### HATEOAS - Level 3 Richardson
En el archivo archivo `pom.xml` agregue la dependencia
```
        <!--Hateoas - Nivel 3 Richardson-->
        <!-- Source: https://mvnrepository.com/artifact/org.springframework.hateoas/spring-hateoas -->
        <dependency>
            <groupId>org.springframework.hateoas</groupId>
            <artifactId>spring-hateoas</artifactId>
            <version>3.0.3</version>
            <scope>compile</scope>
        </dependency>
```

## Validaciones

En el archivo archivo `pom.xml` agregue la dependencia
```
        <!-- Source: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <version>4.0.6</version>
            <scope>compile</scope>
        </dependency>
```