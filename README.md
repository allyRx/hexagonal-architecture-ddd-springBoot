# Gestion de Prêt Bancaire - Spring Boot

Une application Spring Boot pour gérer les demandes de prêt bancaire avec une architecture hexagonale (ports et adaptateurs).

## 📋 Description

Cette application permet de :
- Soumettre des demandes de prêt bancaire
- Vérifier les demandes de prêt existantes
- Traiter et approuver/rejeter les demandes
- Effectuer des vérifications de crédit automatiques
- Envoyer des notifications aux clients

## 🏗️ Architecture

Le projet utilise une **architecture hexagonale** (ports et adaptateurs) pour une séparation claire des responsabilités :

```
Domain (cœur métier)
├── Models (Client, LoanApplication)
├── Ports (interfaces)
│   ├── In (Use Cases primaires)
│   └── Out (Ports secondaires)
└── Services (logique métier)

Adapters (connecteurs externes)
├── In (Contrôleurs REST)
├── Out
│   ├── Persistence (JPA)
│   ├── External (services externes)
│   └── Notification (email)

Application (configuration)
└── Config (beans Spring)
```

## 🛠️ Technologie

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Maven**

## 📦 Prérequis

- JDK 17 ou supérieur
- Maven 3.6+
- Base de données (H2 par défaut, configurable)

## 🚀 Installation et Démarrage

### 1. Cloner le projet
```bash
git clone <repository-url>
cd Gestion-pret-bancaire-SpringBoot
```

### 2. Construire le projet
```bash
mvn clean build
```

### 3. Démarrer l'application
```bash
mvn spring-boot:run
```

L'application démarrera sur `http://localhost:8080`

## 📡 API Endpoints

### 1. Soumettre une demande de prêt
**POST** `/api/loans`

**Request Body:**
```json
{
  "clientId": "client123",
  "requestedAmount": 50000,
  "termInMonths": 60
}
```

**Response (201 Created):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "clientId": "client123",
  "requestedAmount": 50000,
  "termInMonths": 60,
  "status": "PENDING",
  "applicationDate": "2026-01-17T22:56:12",
  "rejectionReason": null
}
```

### 2. Récupérer les détails d'une demande
**GET** `/api/loans/{id}`

**Response (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "clientId": "client123",
  "requestedAmount": 50000,
  "termInMonths": 60,
  "status": "PENDING",
  "applicationDate": "2026-01-17T22:56:12",
  "rejectionReason": null
}
```

### 3. Traiter une demande de prêt
**POST** `/api/loans/{id}/process`

Effectue la vérification de crédit et approuve/rejette la demande.

**Response (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "clientId": "client123",
  "requestedAmount": 50000,
  "termInMonths": 60,
  "status": "APPROVED",
  "applicationDate": "2026-01-17T22:56:12",
  "rejectionReason": null
}
```

## 📁 Structure du Projet

```
src/
├── main/
│   ├── java/com/vasia/gestionpretbancairespringboot/
│   │   ├── adapter/
│   │   │   ├── in/
│   │   │   │   ├── dto/              # Data Transfer Objects
│   │   │   │   └── web/              # Contrôleurs REST
│   │   │   └── out/
│   │   │       ├── persistence/      # Adaptateurs JPA
│   │   │       ├── external/         # Services externes
│   │   │       └── notification/     # Service de notification
│   │   ├── application/
│   │   │   └── config/               # Configuration Spring
│   │   ├── domain/
│   │   │   ├── model/                # Entités de domaine
│   │   │   ├── port/                 # Interfaces (ports)
│   │   │   └── service/              # Logique métier
│   │   └── GestionPretBancaireSpringBootApplication.java
│   └── resources/
│       └── application.properties     # Configuration
└── test/
    └── java/                          # Tests unitaires
```

## 🔧 Configuration

Éditez `src/main/resources/application.properties` pour configurer :

- Port de l'application
- Base de données
- Niveau de log
- Paramètres JPA/Hibernate

Exemple :
```properties
server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
logging.level.root=INFO
```

## 💡 Exemple d'Utilisation

### Curl
```bash
# Soumettre une demande
curl -X POST http://localhost:8080/api/loans \
  -H "Content-Type: application/json" \
  -d '{
    "clientId": "client123",
    "requestedAmount": 50000,
    "termInMonths": 60
  }'

# Récupérer une demande
curl -X GET http://localhost:8080/api/loans/550e8400-e29b-41d4-a716-446655440000

# Traiter une demande
curl -X POST http://localhost:8080/api/loans/550e8400-e29b-41d4-a716-446655440000/process
```

## 🧪 Tests

Pour exécuter les tests :
```bash
mvn test
```

## 📝 Statuts de Demande

- **PENDING** : Demande en attente de traitement
- **APPROVED** : Demande approuvée
- **REJECTED** : Demande rejetée

## 🔐 Règles Métier

- Le montant demandé doit être supérieur à zéro
- La vérification de crédit doit être effectuée avant approbation
- Une demande approuvée génère une notification au client
- Une demande rejetée inclut une raison de rejet

## 🤝 Contribution

Les contributions sont bienvenues ! N'hésitez pas à créer des issues ou des pull requests.

## 📄 Licence

Ce projet est sous licence MIT.

## 👨‍💻 Auteur

Vasia Gestion Prêt Bancaire Team

---

**Dernière mise à jour:** 17 janvier 2026
