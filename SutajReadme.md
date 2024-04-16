### Kurzdokumentation: Wichtige Befehle und Konfigurationen

#### Docker: Container-Management

**Image bauen:**

bash

`docker build -t [name]:[tag] .`

**Container starten:**

bash

`docker run -d -p [host-port]:[container-port] [name]:[tag]`

#### Maven: Projektmanagement

**Projekt bauen:**

bash

`mvn clean install`

**Tests durchführen:**

bash

`mvn test`

#### MySQL: Datenbank-Setup

**Datenbank erstellen:**

mysql

`CREATE DATABASE db_example; -- Erstellt die neue Datenbank`

**Benutzer erstellen:**

mysql

`CREATE USER 'springuser'@'%' IDENTIFIED BY 'ThePassword'; -- Erstellt den Benutzer`

**Rechte vergeben:**

mysql

`GRANT ALL ON db_example.* TO 'springuser'@'%'; -- Vergibt alle Rechte an den neuen Benutzer`

#### Spring Boot: Konfiguration

**application.properties einrichten:** Erstelle die Datei `src/main/resources/application.properties` mit folgenden Inhalten:

properties

`spring.jpa.hibernate.ddl-auto=update spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example spring.datasource.username=springuser spring.datasource.password=ThePassword spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver #spring.jpa.show-sql: true`

Diese Konfiguration verbindet Spring Boot mit einer MySQL-Datenbank und setzt verschiedene Datenbankparameter.
