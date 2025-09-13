# Spring Boot Cinema Booking System

A comprehensive cinema booking system built with Spring Boot, featuring cinema management, film scheduling, ticket
booking, and user administration.

## Features

### Core Functionality

- **Cinema Management**: Manage multiple cinema locations and their halls
- **Film Management**: Add, edit, and manage films with actors and genres
- **Session Scheduling**: Schedule film sessions across different halls and times
- **Ticket Booking**: Book seats for specific film sessions with pricing
- **User Management**: User registration, authentication, and profile management
- **Admin Panel**: Administrative interface for managing all system entities
- **Discount System**: Apply discounts to tickets based on various criteria

### Technical Features

- **Spring Security**: Role-based authentication and authorization
- **Thymeleaf Templates**: Server-side rendering with modern UI
- **JPA/Hibernate**: Database persistence with MySQL
- **Docker Compose**: Easy database setup and development
- **Responsive Design**: Mobile-friendly user interface

## Technology Stack

- **Backend**: Spring Boot 3.5.5 with Java 21
- **Database**: MySQL 9.4.0
- **Template Engine**: Thymeleaf with Spring Security integration
- **ORM**: Spring Data JPA with Hibernate
- **Security**: Spring Security
- **Build Tool**: Gradle
- **Containerization**: Docker Compose

## Architecture

The application follows a layered architecture pattern:

```
├── Controller Layer (Web/REST endpoints)
├── Service Layer (Business logic)
├── Repository Layer (Data access)
└── Entity Layer (Domain models)
```

### Main Entities

- **Cinema**: Cinema locations with multiple halls
- **Hall**: Screening rooms with configurable seating
- **Film**: Movies with associated actors and genres
- **FilmSession**: Scheduled screenings of films
- **Ticket**: Booking records for specific seats
- **User**: System users with role-based access
- **Seat**: Individual seats within halls
- **Actor**: Film cast members
- **Genre**: Film categories
- **Discount**: Pricing discount rules

## Getting Started

### Prerequisites

- Java 21 or higher
- Docker and Docker Compose
- Gradle (included via wrapper)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/hendisantika/springboot-cinema-booking-system.git
   cd springboot-cinema-booking-system
   ```

2. **Start the database**
   ```bash
   docker-compose up -d
   ```
   This will start MySQL on port 3307 with database `cinema_db`.

3. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

4. **Access the application**
    - Web interface: http://localhost:8080
    - Admin panel: http://localhost:8080/admin (requires admin role)

### Database Configuration

The application uses MySQL with the following default configuration:

- Host: localhost:3307
- Database: cinema_db
- Username: yuji
- Password: 53cret
- Timezone: Asia/Jakarta

Configuration can be modified in `src/main/resources/application.properties`.

## Project Structure

```
src/
├── main/
│   ├── java/com/hendisantika/cinemabookingsystem/
│   │   ├── config/           # Spring configuration
│   │   ├── controller/       # Web controllers
│   │   ├── entity/           # JPA entities
│   │   ├── exception/        # Custom exceptions
│   │   ├── repository/       # Data repositories
│   │   ├── service/          # Business logic services
│   │   └── util/             # Utility classes
│   └── resources/
│       ├── templates/        # Thymeleaf templates
│       │   ├── admin/        # Admin interface templates
│       │   └── details/      # Detail view templates
│       └── static/           # CSS, JS, images
└── test/                     # Test classes
```

## API Endpoints

### Public Endpoints

- `/` - Home page with film listings
- `/login` - User authentication
- `/registration` - User registration
- `/films` - Browse available films
- `/cinemas` - Browse cinema locations

### User Endpoints

- `/tickets` - View user's booked tickets
- `/book/{sessionId}` - Book tickets for a session

### Admin Endpoints

- `/admin` - Admin dashboard
- `/admin/films` - Manage films
- `/admin/cinemas` - Manage cinemas
- `/admin/sessions` - Manage film sessions
- `/admin/users` - Manage users

## Development

### Running Tests

```bash
./gradlew test
```

### Building the Application

```bash
./gradlew build
```

### Database Schema

The application uses Hibernate DDL auto-generation (`update` mode). The database schema is automatically created and
updated based on JPA entity definitions.

## Security

The application implements Spring Security with:

- Form-based authentication
- Role-based authorization (USER, ADMIN)
- CSRF protection
- Session management
- Password encoding

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**Hendi Santika** - [hendisantika](https://github.com/hendisantika)
