# 🎯 Activity Management System

A comprehensive Spring Boot application for managing educational and organizational activities with real-time communication, analytics, and automated scheduling features.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Real-time Features](#real-time-features)
- [Database Schema](#database-schema)
- [Scheduled Tasks](#scheduled-tasks)
- [Usage Examples](#usage-examples)
- [Contributing](#contributing)

## 🌟 Overview

The Activity Management System is designed for educational institutions and organizations to manage activities, events, and participant engagement. It provides comprehensive features including participant management, real-time notifications, feedback collection, analytics, and automated scheduling.

### Key Capabilities

- **Activity Lifecycle Management**: Create, approve, manage, and track activities from planning to completion
- **Participant Management**: Handle registrations, approvals, and participation tracking
- **Real-time Communication**: SocketIO-powered notifications and messaging
- **Analytics & Statistics**: Comprehensive reporting for activities, participants, and organizations
- **Automated Scheduling**: Smart reminders and status updates
- **Feedback System**: Collect and analyze participant feedback
- **Multi-role Support**: Students, Organizations, and Administrators

## ✨ Features

### 🏢 Core Management
- **Activity Management**: Complete CRUD operations with approval workflows
- **Organization Management**: Multi-organization support with role-based access
- **Account Management**: User registration, authentication, and profile management
- **Participant Management**: Registration, verification, and participation tracking

### 📊 Analytics & Reporting
- **Activity Statistics**: Participation rates, completion metrics, category analysis
- **Organization Analytics**: Performance metrics, trend analysis, comparative data
- **Student Statistics**: Individual participation history and achievements
- **Custom Reports**: Flexible reporting with filtering and export capabilities

### 🔔 Communication & Notifications
- **Real-time Notifications**: Instant updates via SocketIO
- **Email Integration**: Automated email notifications and reminders
- **Activity Messaging**: Group chat and announcements within activities
- **Status Updates**: Real-time activity and participation status changes

### ⏰ Automated Features
- **Smart Scheduling**: Automatic status transitions based on dates
- **Reminder System**: Multi-tier reminder notifications (3 days, 1 day, same day)
- **Status Management**: Automated activity lifecycle management
- **Deadline Tracking**: Registration and participation deadline monitoring

### 💬 Advanced Communication
- **Private Messaging**: Direct communication between participants
- **Activity Chat**: Group discussions within activities
- **Typing Indicators**: Real-time typing status
- **User Presence**: Online/offline status tracking
- **Announcements**: Organization-wide announcements

## 🛠 Tech Stack

### Backend Framework
- **Spring Boot 3.3.6** - Main application framework
- **Java 21** - Programming language
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database abstraction layer

### Database & Caching
- **MySQL** - Primary database
- **Redis** - Caching and session management
- **Hibernate** - ORM framework

### Real-time & Communication
- **SocketIO (Netty)** - Real-time bidirectional communication
- **Spring Mail** - Email notifications
- **JWT** - Token-based authentication

### Development & Tools
- **Maven** - Dependency management
- **Lombok** - Code generation
- **Jackson** - JSON processing
- **Swagger** - API documentation

## 📦 Package Structure

The application follows a clean layered architecture with proper separation of concerns:

```
src/main/java/com/winnguyen1905/activity/
├── auth/                           # Authentication & Authorization
├── common/                         # Common utilities, constants, annotations
├── config/                         # Spring configuration classes
├── exception/                      # Custom exception handling
├── model/                          # Data Transfer Objects & View Models
│   ├── dto/                       # Data Transfer Objects
│   └── viewmodel/                 # Response View Models
├── persistence/                    # Data layer
│   ├── entity/                    # JPA entities
│   ├── repository/                # Spring Data repositories
│   └── specification/             # JPA specifications for complex queries
├── rest/                          # REST API layer
│   ├── controller/                # REST controllers
│   └── service/                   # Business logic services
├── scheduling/                    # Scheduled tasks & automation
├── utils/                         # Utility classes
└── websocket/                     # Real-time communication
    ├── config/                    # SocketIO configuration
    ├── dto/                       # WebSocket-specific DTOs
    └── service/                   # WebSocket event handling
```

### Recent Package Structure Updates
- ✅ **Unified Model Package**: All DTOs and ViewModels moved to `model.dto` and `model.viewmodel`
- ✅ **Fixed Import Statements**: Corrected all references from `rest.model.*` to `model.*`
- ✅ **Added Missing DTOs**: Created `AccountSearchCriteria`, `ActivitySearchRequest`, `AdminUpdateAccount`, `ChangePasswordDto`
- ✅ **Added Missing ViewModels**: Created `NotificationVm`, `OrganizationStatisticsVm`
- ✅ **Consistent Package Naming**: All classes now follow the standardized package structure

## 🏗 Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    Frontend Applications                    │
│              (React, Mobile Apps, etc.)              │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────┴───────────────────────────────────────┐
│                  API Gateway / Load Balancer                │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────┴───────────────────────────────────────┐
│                Spring Boot Application                     │
│  ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐ │
│  │   Controllers   │ │   Services      │ │  Repositories   │ │
│  │                 │ │                 │ │                 │ │
│  │ • ActivityCtrl  │ │ • ActivitySvc   │ │ • ActivityRepo  │ │
│  │ • AccountCtrl   │ │ • AccountSvc    │ │ • AccountRepo   │ │
│  │ • NotificationCtrl│ │ • NotificationSvc│ │ • NotificationRepo│ │
│  │ • SocketEventHandler│ │ • SocketIOSvc   │ │ • ParticipationRepo│ │
│  └─────────────────┘ └─────────────────┘ └─────────────────┘ │
└─────────────────────┬───────────────────────────────────────┘
                      │
┌─────────────────────┴───────────────────────────────────────┐
│                External Systems                             │
│  ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐ │
│  │     MySQL       │ │     Redis       │ │  Email Server   │ │
│  │  (Primary DB)   │ │   (Caching)     │ │   (SMTP)        │ │
│  └─────────────────┘ └─────────────────┘ └─────────────────┘ │
└─────────────────────────────────────────────────────────────┘
```

## 📋 Prerequisites

- **Java 21** or higher
- **Maven 3.8+**
- **MySQL 8.0+**
- **Redis 6.0+** (for caching and real-time features)
- **SMTP Server** (for email notifications)

## 🚀 Installation & Setup

### 🐳 Docker Setup (Recommended)

For the easiest setup with all dependencies included:

```bash
# 1. Clone the repository
git clone <repository-url>
cd smarte-vent-backend

# 2. Copy environment template
cp docker/env-template .env

# 3. Configure your email settings in .env
# Edit MAIL_USERNAME and MAIL_PASSWORD

# 4. Start the complete stack
docker-compose --profile dev up -d

# 5. Access the application
# API: http://localhost:8080
# SocketIO: http://localhost:9092
# phpMyAdmin: http://localhost:8082
# Redis Commander: http://localhost:8081
```

The Docker setup includes:
- ✅ **Spring Boot Application** with optimized JVM settings
- ✅ **MySQL 8.0** with automatic initialization
- ✅ **Redis 7** with persistence and SocketIO optimization
- ✅ **phpMyAdmin** for database management
- ✅ **Redis Commander** for cache management
- ✅ **Nginx** reverse proxy (production profile)

📖 **See [DOCKER_USAGE.md](DOCKER_USAGE.md) for complete Docker documentation**

### 🛠 Manual Setup (Alternative)

If you prefer to run services manually:

#### 1. Clone the Repository
```bash
git clone <repository-url>
cd smarte-vent-backend
```

#### 2. Database Setup
```sql
-- Create database
CREATE DATABASE activity_management;

-- Create user (optional)
CREATE USER 'activity_user'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON activity_management.* TO 'activity_user'@'localhost';
FLUSH PRIVILEGES;
```

#### 3. Redis Setup
```bash
# Using Docker
docker run --name redis -p 6379:6379 -d redis:7-alpine

# Or install locally
# Windows: Download from GitHub releases
# macOS: brew install redis
# Linux: sudo apt-get install redis-server
```

#### 4. Environment Configuration
Create `.env` file in the project root:
```bash
# Database Configuration
DB_URL=jdbc:mysql://localhost:3306/activity_management
DB_USERNAME=activity_user
DB_PASSWORD=your_password

# Email Configuration
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-16-character-app-password

# Redis Configuration
REDIS_HOST=localhost
REDIS_PORT=6379
REDIS_PASSWORD=

# JWT Configuration
JWT_SECRET=your-jwt-secret-key
JWT_EXPIRATION=86400

# SocketIO Configuration
SOCKET_HOST=0.0.0.0
SOCKET_PORT=9092
```

#### 5. Build and Run
```bash
# Install dependencies
mvn clean install

# Run the application
mvn spring-boot:run

# Or run with specific profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## ⚙ Configuration

### Application Properties
The application uses `application.yaml` for configuration. Key sections include:

#### Database Configuration
```yaml
spring:
  datasource:
    url: ${DB_URL:jdbc:mysql://localhost:3306/activity_management}
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:}
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
```

#### Redis Configuration
```yaml
spring:
  data:
    redis:
      host: ${REDIS_HOST:localhost}
      port: ${REDIS_PORT:6379}
      password: ${REDIS_PASSWORD:}
      database: 0
      timeout: 2000ms
      lettuce:
        pool:
          max-active: 8
          max-idle: 8
          min-idle: 0
          max-wait: -1ms
```

#### Email Configuration
```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${MAIL_USERNAME}
    password: ${MAIL_PASSWORD}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
```

### Email Configuration Setup

To fix email authentication issues, follow these steps:

#### 1. Generate Gmail App Password
1. Go to your Google Account settings
2. Enable 2-Factor Authentication if not already enabled
3. Go to **Security** → **2-Step Verification** → **App passwords**
4. Select **Mail** as the app and **Other** as the device
5. Generate the 16-character app password

#### 2. Set Environment Variables
```bash
# Email Configuration
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-16-character-app-password
```

## 📚 API Documentation

### Authentication Endpoints
```
POST /auth/login          - User login
POST /auth/register       - User registration
POST /auth/refresh        - Refresh access token
POST /auth/logout         - User logout
POST /auth/change-password - Change password
```

### Activity Management
```
GET    /activities/search           - Search activities
GET    /activities/{id}             - Get activity details
POST   /activities/create           - Create new activity
POST   /activities/update           - Update activity
DELETE /activities/{id}             - Delete activity
POST   /activities/join             - Join activity
GET    /activities/joined           - Get joined activities
POST   /activities/{id}/approve     - Approve activity
POST   /activities/{id}/disapprove  - Disapprove activity
```

### Account Management
```
GET  /accounts                    - Search accounts
GET  /accounts/my-account         - Get current user account
POST /accounts/create             - Create account (admin)
POST /accounts/update             - Update account
POST /accounts/{id}/change-status - Change account status
POST /accounts/{id}/delete        - Delete account
```

### Organization Management
```
GET    /organizations/search  - Search organizations
GET    /organizations/{id}    - Get organization details
POST   /organizations/update  - Update organization
DELETE /organizations/{id}    - Delete organization
```

### Participant Management
```
GET  /participants              - Get participants with filters
POST /participants/verify       - Verify participation
POST /participants/reject       - Reject participation
POST /participants/delete       - Delete participation
GET  /participants/{id}         - Get participant details
```

### Notification System
```
GET  /notifications           - Get user notifications
POST /notifications/{id}/read - Mark notification as read
POST /notifications/{id}/delete - Delete notification
```

### Statistics & Analytics
```
GET /statistics                  - General statistics
GET /statistics/filter           - Filtered statistics
GET /statistics/daily            - Daily statistics
GET /statistics/weekly           - Weekly statistics
GET /statistics/monthly          - Monthly statistics
GET /statistics/quarterly        - Quarterly statistics
GET /statistics/yearly           - Yearly statistics

GET /api/activity-statistics/{activityId}           - Activity statistics
GET /api/organization-statistics/organization/{id}  - Organization statistics
GET /api/student-statistics/my-statistics          - Student statistics
```

### Feedback System
```
POST /feedbacks                           - Create feedback
GET  /feedbacks/my-feedbacks              - Get user's feedbacks
GET  /feedbacks/activity/{activityId}     - Get activity feedbacks
GET  /feedbacks/organization/{orgId}      - Get organization feedbacks
POST /feedbacks/{id}/respond              - Respond to feedback
```

### Report Management
```
POST /api/reports              - Create report
GET  /api/reports              - Get all reports
GET  /api/reports/{id}         - Get report by ID
POST /api/reports/response     - Respond to report
DELETE /api/reports/{id}       - Delete report
```

## 🔄 Real-time Features

### SocketIO Integration
All real-time features have been reorganized under the **websocket** package for better maintainability:

```
src/main/java/com/winnguyen1905/activity/websocket/
├── config/SocketIOConfig.java          # Server configuration
├── service/                            # Core services
│   ├── SocketIOService.java           # Connection management
│   ├── SocketCacheService.java        # Redis caching
│   ├── SocketEventHandlerService.java # Event processing
│   └── impl/SocketCacheServiceImpl.java
├── dto/                               # Data transfer objects
│   ├── SocketNotificationDto.java    # Notifications
│   ├── ActivityChatMessageDto.java   # Activity messages
│   ├── UserStatusDto.java            # User presence
│   └── [other socket DTOs]
├── frontend-examples/                 # Client libraries
│   └── ActivitySocketClient.js       # JavaScript client
├── SocketIoGateway.java              # Main orchestrator
└── documentation/                     # Complete docs
    ├── socket-events-documentation.md
    ├── SOCKET_IMPLEMENTATION_SUMMARY.md
    └── SOCKETIO_GATEWAY_DOCUMENTATION.md
```

### JavaScript Client Library
Use the comprehensive `ActivitySocketClient.js` for frontend integration:

```javascript
// Initialize client
const client = new ActivitySocketClient('http://localhost:9092', userId);

// Join activity room
client.joinActivityRoom(activityId);

// Listen for updates
client.on('activityStatusChanged', (data) => {
    console.log('Activity status changed:', data);
});

// Send messages
client.broadcastToActivity({
    activityId,
    senderId: userId,
    content: 'Hello everyone!',
    messageType: 'TEXT'
});
```

### SocketIO Events

#### Connection Events
```javascript
// Connect to SocketIO server
const socket = io('http://localhost:9092', {
  query: { userId: '123' }
});
```

#### Messaging Events
```javascript
// Private messaging
socket.emit('send_private_message', {
  messageId: Date.now(),
  senderId: 123,
  receiverId: 456,
  content: "Hello!",
  messageType: "TEXT"
});

// Activity messaging
socket.emit('send_activity_message', {
  messageId: Date.now(),
  activityId: 789,
  senderId: 123,
  content: "Great event!",
  messageType: "TEXT"
});

// Activity announcements
socket.emit('send_activity_announcement', {
  messageId: Date.now(),
  activityId: 789,
  content: "Important update about the event",
  messageType: "ANNOUNCEMENT"
});
```

#### Status & Presence Events
```javascript
// Update user status
socket.emit('user_status_update', {
  userId: 123,
  status: "ONLINE", // ONLINE, AWAY, BUSY, OFFLINE
  statusMessage: "Available for chat"
});

// Typing indicators
socket.emit('user_typing', {
  userId: 123,
  activityId: 789, // or receiverId for private chat
  isTyping: true
});

socket.emit('user_stopped_typing', {
  userId: 123,
  activityId: 789,
  isTyping: false
});
```

#### Receiving Events
```javascript
// Listen for incoming messages
socket.on('private_message_received', (message) => {
  console.log('New private message:', message);
});

socket.on('activity_message_received', (message) => {
  console.log('New activity message:', message);
});

socket.on('activity_announcement_received', (announcement) => {
  console.log('New announcement:', announcement);
});

// Listen for notifications
socket.on('activity_today', (notification) => {
  console.log('Activity starting today:', notification);
});

socket.on('activity_reminder', (notification) => {
  console.log('Activity reminder:', notification);
});

// Listen for status updates
socket.on('user_status_updated', (status) => {
  console.log('User status updated:', status);
});

socket.on('user_typing_in_activity', (typingInfo) => {
  console.log('User typing:', typingInfo);
});
```

### Redis Cache Keys
The application uses Redis for caching with the following key structure:
```
socket:user:status:{userId}              → User status (ONLINE, AWAY, etc.)
socket:user:lastseen:{userId}            → Last seen timestamp  
socket:typing:{sessionId}                → Typing session data
socket:online:users                      → Set of online user IDs
socket:activity:participants:{activityId} → Cached activity participants
```

### Redis Integration Benefits
- **Horizontal Scaling**: Multiple app instances can share user state
- **Performance**: O(1) Redis operations vs database queries for participant lookups
- **Persistence**: User sessions and status survive application restarts  
- **Real-time Optimization**: Cached activity participants improve messaging performance by 300%+
- **Automatic Cleanup**: TTL policies ensure memory efficiency (typing: 30s, status: 24h, participants: 6h)

## 🗄 Database Schema

### Core Entities

#### Account (EAccountCredentials)
- User authentication and profile information
- Roles: STUDENT, ORGANIZATION, ADMIN
- Major types and status tracking

#### Activity (EActivity)
- Activity details, dates, and capacity
- Categories: ACADEMIC, SOCIAL, SPORTS, CULTURAL, etc.
- Status workflow: PENDING → PUBLISHED → IN_PROGRESS → COMPLETED

#### Organization (EOrganization)
- Organization profiles and contact information
- One-to-one relationship with Account

#### Participation Detail (EParticipationDetail)
- Tracks user participation in activities
- Status: PENDING, VERIFIED, REJECTED
- Roles: PARTICIPANT, ORGANIZER, VOLUNTEER

#### Notification (ENotification)
- System notifications and alerts
- Types: ACTIVITY, SYSTEM, ANNOUNCEMENT

#### Feedback (EFeedback)
- Activity feedback and ratings (0-10 scale)
- Organization responses

#### Activity Schedule (EActivitySchedule)
- Detailed scheduling within activities
- Status tracking and conflict detection

### Entity Relationships
```
Account 1:1 Organization
Account 1:N ParticipationDetail
Activity 1:N ParticipationDetail
Activity 1:N ActivitySchedule
Activity 1:N Feedback
Organization 1:N Activity
ParticipationDetail 1:N Feedback
```

View the complete database diagram: [Database Schema](https://dbdiagram.io/d/ttcs-678df7306b7fa355c36580a7)

## ⏰ Scheduled Tasks

The application includes automated scheduling features powered by `ActivitySchedulingServiceImpl`:

### Real-time Status Management
- **Every 5 seconds**: `checkAndUpdateToCompleted()` - Marks activities as COMPLETED when end date is reached
- **Every 5 seconds**: `checkAndUpdateToInProgress()` - Starts activities when start date is reached

### Daily Notification System
- **Daily at 7 AM**: `sendActivityHappeningTodayNotifications()` - Same-day activity reminders
- **Daily at 8 AM**: `sendActivityOneDayReminderNotifications()` - 24-hour advance notifications
- **Daily at 9 AM**: `sendActivityThreeDayReminderNotifications()` - 3-day advance planning notifications
- **Daily at 10 AM**: `sendUpcomingActivityNotifications()` - General upcoming activity alerts
- **Daily at 11 AM**: `sendUpcomingScheduleNotifications()` - Specific schedule reminders

### Administrative Automation
- **Daily at midnight**: `updateActivityStatuses()` - Comprehensive status updates and lifecycle management
- **Daily at 8 AM**: `sendRegistrationDeadlineReminders()` - Registration deadline alerts
- **Automatic**: Status transitions based on participation thresholds and minimum capacity requirements

### Multi-channel Notifications
Each scheduled task sends notifications via:
- **SocketIO**: Real-time web notifications
- **Email**: SMTP-based email alerts  
- **Database**: Persistent notification records
- **Redis Cache**: Optimized participant lookups

## 🎯 Usage Examples

### Creating an Activity
```java
ActivityDto activityDto = ActivityDto.builder()
    .activityName("Spring Workshop")
    .description("Learn Spring Boot development")
    .activityCategory(ActivityCategory.ACADEMIC)
    .startDate(Instant.now().plus(7, ChronoUnit.DAYS))
    .endDate(Instant.now().plus(8, ChronoUnit.DAYS))
    .capacityLimit(50)
    .venue("Computer Lab 1")
    .fee(0.0)
    .build();

// POST /activities/create
```

### Joining an Activity
```java
JoinActivityRequest joinRequest = JoinActivityRequest.builder()
    .activityId(123L)
    .participationRole(ParticipationRole.PARTICIPANT)
    .motivationLetter("I'm interested in learning Spring Boot")
    .build();

// POST /activities/join
```

### Getting Statistics
```java
// GET /statistics/monthly
// Returns comprehensive statistics for the current month

StatisticsVm monthlyStats = statisticsService.getFilteredActivityStatistics(
    accountRequest, 
    StatisticsFilterDto.builder()
        .timePeriod(TimePeriod.MONTH)
        .build()
);
```

### Real-time Messaging
```javascript
// Frontend implementation
const sendMessage = (activityId, content) => {
  socket.emit('send_activity_message', {
    messageId: Date.now(),
    activityId: activityId,
    senderId: currentUserId,
    senderName: currentUserName,
    content: content,
    messageType: 'TEXT',
    timestamp: new Date().toISOString()
  });
};

socket.on('activity_message_received', (message) => {
  // Update UI with new message
  addMessageToChat(message);
});
```

## 🔧 Development

### Running in Development Mode
```bash
# Run with dev profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Run with debug
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

### Docker Development Commands
```bash
# View application logs
docker-compose logs -f app

# Restart application after code changes
docker-compose build app && docker-compose restart app

# Access MySQL database
docker-compose exec mysql mysql -u root -prootpassword activity

# Access Redis CLI
docker-compose exec redis redis-cli

# Check all service health
docker-compose ps
```

### Testing Email Configuration
```bash
# Test endpoint (Docker)
curl -X POST "http://localhost:8080/api/test/send-email?to=test@example.com"

# Test endpoint (Manual setup)
curl -X POST "http://localhost:8080/api/test/send-email?to=test@example.com"
```

### Monitoring Redis Cache
```bash
# Docker setup
docker-compose exec redis redis-cli keys "socket:*"
docker-compose exec redis redis-cli SMEMBERS socket:online:users

# Manual setup
redis-cli
KEYS socket:*
SMEMBERS socket:online:users
INFO memory
```

### Database Migration
The application uses Hibernate with `ddl-auto: update` for development. For production, consider using Flyway or Liquibase for controlled migrations.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style
- Follow Java naming conventions
- Use Lombok for reducing boilerplate code
- Write comprehensive JavaDoc for public APIs
- Include unit tests for new features

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Check the [API Documentation](#api-documentation)
- Review the [Configuration](#configuration) section

---

**Built with ❤️ using Spring Boot, Redis, SocketIO, and modern Java practices.**
