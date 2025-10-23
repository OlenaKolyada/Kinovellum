# Functional Requirements

## 1. Registration and Account Management

### 1.1. Platform Registration
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Implement platform registration functionality with mandatory fields and email confirmation. Registration fields include:
    * Email (mandatory field)
    * Password (mandatory field)
    * Username (mandatory field)
* **Requirement Priority:** High.

### 1.2. Registration via Third-Party Services
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide the ability to register and log in via third-party platforms (Google, social networks).
* **Requirement Priority:** Medium.

### 1.3. System Login
* **Requirement Source:** All user types.
* **Requirement Description:** Provide the ability to authenticate users via email and password or through third-party services.
* **Requirement Priority:** High.

## 2. Managing Viewing Entries

### 2.1. Adding a Viewing Entry
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Implement functionality for adding a movie viewing entry to the diary. Each viewing is recorded as a separate entry, allowing users to add multiple entries for the same movie during rewatches. Entry fields include:
    * Movie title (search from database)
    * Viewing date
    * Rating (scale 1-10)
    * Comment (text field)
* **Requirement Priority:** High.

### 2.2. Editing a Viewing Entry
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide the ability to edit existing entries (change rating, comment, date).
* **Requirement Priority:** High.

### 2.3. Deleting a Viewing Entry
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide the ability to delete viewing entries.
* **Requirement Priority:** High.

## 3. Viewing and Filtering Viewing History

### 3.1. Viewing History Display
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Implement the ability to view a complete list of viewing entries with information about the movie, date, rating, and comment.
* **Requirement Priority:** High.

### 3.2. Entry Sorting
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide the ability to sort entries by viewing date, rating, or movie title.
* **Requirement Priority:** Medium.

### 3.3. Entry Filtering
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide the ability to filter entries by time period, rating, or other parameters.
* **Requirement Priority:** Medium.

## 4. Viewing Statistics

### 4.1. General Statistics
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Develop functionality to display general viewing statistics:
    * Total number of watched movies
    * Average rating of all viewings
    * Number of viewings for current month/year
* **Requirement Priority:** Medium.

### 4.2. Detailed Statistics
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide detailed analytics by genres, release years, directors (for future versions).
* **Requirement Priority:** Low.

## 5. User Profile Management

### 5.1. User Profile
* **Requirement Source:** All user types.
* **Requirement Description:** Develop the ability to view and edit user profile with basic information (name, email, avatar).
* **Requirement Priority:** Medium.

### 5.2. Privacy Settings
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Provide the ability to manage diary visibility (public/private) for future versions.
* **Requirement Priority:** Low.

## 6. Administrative Functions

### 6.1. Movie Database Management
* **Requirement Source:** System administrators.
* **Requirement Description:** Implement functionality for adding, editing, and deleting movies in the database.
* **Requirement Priority:** Medium.

### 6.2. Content Moderation
* **Requirement Source:** System administrators.
* **Requirement Description:** Provide the ability to view and delete inappropriate user content.
* **Requirement Priority:** Medium.

### 6.3. User Management
* **Requirement Source:** System administrators.
* **Requirement Description:** Provide the ability to block/unblock users when necessary.
* **Requirement Priority:** Medium.

## 7. Movie Search

### 7.1. Search by Title
* **Requirement Source:** Movie enthusiast users.
* **Requirement Description:** Implement movie search functionality by title when adding an entry.
* **Requirement Priority:** High.

### 7.2. External API Integration
* **Requirement Source:** Developers.
* **Requirement Description:** Provide integration with external APIs (e.g., TMDb) to retrieve movie information.
* **Requirement Priority:** High.