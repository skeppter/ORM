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

Erklärung des Warehouse Entity Snippets

Das Warehouse Entity repräsentiert eine Datenbanktabelle in einer Java-Anwendung, die Hibernate für das ORM (Object-Relational Mapping) verwendet. Hier die Schlüsselkonzepte:

    @Entity: Diese Annotation signalisiert Hibernate, dass diese Klasse als Datenbanktabelle abgebildet werden soll. Sie macht die Klasse zu einer Entität im Kontext von Hibernate.
    @Id: Kennzeichnet das Feld, das die eindeutige ID (Primärschlüssel) der Entität repräsentiert.
    @GeneratedValue(strategy=GenerationType.AUTO): Diese Annotation gibt an, dass der Wert des ID-Feldes automatisch von der Datenbank generiert wird, wenn ein neuer Datensatz erstellt wird. Die AUTO Strategie bedeutet, dass der Persistenzprovider (wie Hibernate) die beste verfügbare Strategie auswählt, um den Primärschlüssel zu generieren, abhängig von der verwendeten Datenbank.

Quelle: Hibernate ORM Dokumentation
https://hibernate.org/orm/documentation/6.4/
Erklärung der Funktionsweise von Repositories

Ein Repository in Spring Data ist eine Schnittstelle, die das Grundgerüst für die Datenzugriffsschicht einer Anwendung bietet. Es nutzt generische CRUD (Create, Read, Update, Delete) Operationen und reduziert den Boilerplate-Code, der für den Datenzugriff erforderlich ist. Hier die Schlüsselkonzepte des UserRepository:

    CrudRepository<User, Integer>: Das UserRepository erbt von CrudRepository, was bedeutet, dass es eine Menge grundlegender Methoden für Operationen wie das Speichern, Löschen, Suchen und Aktualisieren von User-Entitäten bereitstellt.
    User: Der generische Typ User gibt an, dass das Repository für die Verwaltung von User-Entitäten in der Datenbank verwendet wird.
    Integer: Der zweite generische Typ Integer spezifiziert den Datentyp des Primärschlüssels der User-Entität.
    Automatische Implementierung: Spring Data JPA implementiert automatisch dieses Interface zur Laufzeit und erstellt eine konkrete Klasse, die alle CRUD-Operationen für die User-Entitäten bereitstellt. Dies geschieht ohne, dass manuell Code geschrieben werden muss.

Quelle: Spring Data JPA Dokumentation
https://docs.spring.io/spring-data/jpa/reference/#repositories