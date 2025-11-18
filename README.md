# Gestion des Absences 
**Mini Atelier Spring Boot MVC + JPA + Thymeleaf**

Un projet complet de gestion des absences des étudiants réalisé avec **seulement 2 entités** :  
`Etudiant` ←→ `Absence` (relation OneToMany bidirectionnelle)

![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.7-brightgreen?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-orange)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple?logo=bootstrap)

---

### Fonctionnalités implémentées

- CRUD complet sur les **Étudiants**
- CRUD complet sur les **Absences** (liées à un étudiant)
- Affichage des absences par étudiant
- Interface moderne avec **Bootstrap 5** + icônes Font Awesome
- Page d’accueil stylée et responsive
- Architecture propre en couches : Entity → Repository → Service → Controller → Thymeleaf

---

### Technologies utilisées

| Technologie              | Version | Rôle                                  |
|--------------------------|---------|----------------------------------------|
| Java                     | 21      | Langage principal                      |
| Spring Boot              | 3.5.7   | Framework principal                    |
| Spring Data JPA          | inclus  | Persistance avec Hibernate             |
| MySQL                    | 8.0+    | Base de données                        |
| Thymeleaf                | 3.1     | Moteur de templates                    |
| Lombok                   | inclus  | Réduction du code boilerplate          |
| Bootstrap 5 + Font Awesome | CDN     | Design moderne et responsive           |

---

### Structure du projet
```
src/main/java/ma/fstt/spring_etud/
├── SpringEtudApplication.java
├── controller/
│   ├── EtudiantController.java
│   ├── AbsenceController.java
│   └── HomeController.java
├── entity/
│   ├── Etudiant.java
│   └── Absence.java
├── repository/
│   ├── EtudiantRepository.java
│   └── AbsenceRepository.java
├── service/
│   ├── EtudiantService.java
│   └── AbsenceService.java
└── resources/
├── templates/           
└── application.properties
```

### Base de données

- Nom : `spring_etud`
- Créée automatiquement grâce à `spring.jpa.hibernate.ddl-auto=update`
- Tables générées :
    - `etudiants` (id, nom, prenom, cne, filiere)
    - `absences` (id, date_absence, matiere, nbr_heures, justifiee, etudiant_id)

---

### Comment lancer le projet

1. **Prérequis**
    - Java 21 installé
    - MySQL démarré 
    - Créer la base : `CREATE DATABASE spring_etud;`

2. **Configuration** (`src/main/resources/application.properties`)
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring_etud?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=**********
   spring.jpa.hibernate.ddl-auto=update

Accéder à l’application
* Accueil : http://localhost:8080
* Étudiants : http://localhost:8080/etudiants
* Absences : http://localhost:8080/absences
- Les URLs à visiter (tape-les directement dans ton navigateur) :
URLCe que tu vois 
* http://localhost:8080/etudiantsListe des étudiants (CRUD complet)
* http://localhost:8080/etudiants/newFormulaire pour ajouter un nouvel étudiant
* http://localhost:8080/absencesListe de toutes les absences
* http://localhost:8080/absences/newFormulaire pour ajouter une absence
* http://localhost:8080/absences/etudiant/1Absences d’un étudiant précis 

