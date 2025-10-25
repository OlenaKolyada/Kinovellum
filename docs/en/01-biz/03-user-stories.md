# User Stories

## Movie Enthusiast Users

### User Story 1: Adding a Movie Viewing Entry
As a movie enthusiast user, I want to add an entry about a watched movie with rating and comment, so that I can keep track of my viewing history and impressions.

**Acceptance Criteria:**
- User can search for a movie by title
- User can specify the viewing date
- User can rate the movie (e.g., on a 1-10 scale)
- User can add a text comment about the movie
- The entry is saved and displayed in the user's diary
- User can add multiple entries for the same movie (rewatches)

### User Story 2: Browsing Viewing History
As a movie enthusiast user, I want to view my viewing history, so that I can see which movies I watched and when.

**Acceptance Criteria:**
- User sees a list of all their viewing entries
- Entries are displayed with date, movie title, rating, and comment
- User can sort entries by date or rating
- User can filter entries by time period

### User Story 3: Editing and Deleting Entries
As a movie enthusiast user, I want to edit or delete my entries, so that I can correct mistakes or change my opinion about a movie.

**Acceptance Criteria:**
- User can edit the rating and comment of an existing entry
- User can delete a viewing entry
- All changes are saved correctly

### User Story 4: Viewing Statistics
As a movie enthusiast user, I want to see statistics of my viewings, so that I can analyze my movie preferences.

**Acceptance Criteria:**
- User sees the total number of watched movies
- User sees the average rating of their viewings
- User sees the number of viewings for a specific period
- Statistics are updated automatically when new entries are added

## Developers

### User Story 1: API Development
As a developer, I want to create an API for working with viewing entries, so that the frontend can interact with the backend.

**Acceptance Criteria:**
- API supports CRUD operations for viewing entries
- API returns data in JSON format
- API handles errors and returns appropriate status codes
- API is documented

### User Story 2: Security Implementation
As a developer, I want to implement user authentication and authorization, so that user data is protected.

**Acceptance Criteria:**
- Users can register and log in to the system
- Only the owner has access to their entries
- Passwords are stored in encrypted form
- Protection against unauthorized access is implemented

## Product Owner

### User Story 1: Defining Functional Requirements
As a product owner, I want to define application feature priorities, so that we can focus on the most important capabilities.

**Acceptance Criteria:**
- A list of features with priorities is compiled
- Success criteria are defined for each feature
- Development plan is agreed upon with the development team

## System Administrators

### User Story 1: Content Moderation
As a system administrator, I want to have the ability to moderate user content, so that data quality in the application is maintained.

**Acceptance Criteria:**
- Administrator can view all user entries
- Administrator can delete incorrect content
- Administrator can block users when necessary

### User Story 2: Movie Database Management
As a system administrator, I want to manage the movie database, so that users can find up-to-date information.

**Acceptance Criteria:**
- Administrator can add new movies to the database
- Administrator can edit movie information
- Administrator can remove duplicates

## Course Instructors

### User Story 1: Project Evaluation
As a course instructor, I want to evaluate the quality of the project implementation, so that I can ensure compliance with educational requirements.

**Acceptance Criteria:**
- Project contains complete documentation
- Code complies with Kotlin standards
- All core features are implemented according to the assignment
- Project is deployed and available for review