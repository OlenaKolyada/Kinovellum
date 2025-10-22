# API Description

## 1. Entities

### Diary Entry

| Field | Business Description | Example Value |
|-------|---------------------|---------------|
| id | Unique entry identifier | "446655440000" |
| userId | User identifier (entry owner) | "user:12345" |
| movieId | Movie identifier from database | "movie:tt0111161" |
| movieTitle | Movie title | "The Shawshank Redemption" |
| viewingDate | Viewing date | "2025-10-15" |
| rating | Movie rating (1-10) | 9 |
| comment | User comment | "Amazing film about hope" |
| createdAt | Entry creation date | "2025-10-15T20:30:00Z" |
| updatedAt | Last update date | "2025-10-16T10:00:00Z" |

### Movie

| Field       | Business Description    | Example Value |
|-------------|-------------------------|---------------|
| id          | Unique movie identifier | "movie:tt0111161" |
| title       | Movie title             | "The Shawshank Redemption" |
| releaseYear | Release year            | 1994 |
| director    | Director                | "Frank Darabont" |
| actors      | Actors                  | [Tim Robbins, Morgan Freeman] |
| genre       | Genres                  | ["Drama", "Crime"] |
| description | Description             | "A banker is wrongfully convicted of murdering his wife and her lover, and is sentenced to life in Shawshank State Penitentiary. " |
| posterUrl   | Movie poster URL        | "https://image.tmdb.org/..." |
| tmdbId      | TMDb movie ID           | "278" |

## 2. Business Functions (Methods)

### CRUDS for Diary Entries

1. **`viewings.create`** - Create a new viewing entry
    * Business rule: Only authenticated users can create entries
    * Constraints:
        * Required fields: movieId, viewingDate
        * Rating must be in range 1-10
        * Viewing date cannot be in the future
    * Validation: Check movie existence in database

2. **`viewings.update`** - Update an existing entry
    * Business rule: Only owner can modify their entry
    * Constraints: Cannot change userId and movieId
    * Validation: Access rights verification

3. **`viewings.read`** - Get entry information
    * Business rule: User can view only their own entries
    * Returns: Complete entry information with movie data

4. **`viewings.delete`** - Delete an entry
    * Business rule: Only owner can delete their entry
    * Returns: Successful deletion status

5. **`viewings.list`** - Get user's entry list
    * Business logic: Returns all entries of the current user
    * Filters: By viewing date, rating, movie
    * Sorting: By viewing date (default: newest to oldest), by rating

### CRUDS for Movies

6. **`movies.search`** - Search movies
    * Business logic: Search movies by title first in local database, if not found - query TMDb API and save results to local database
    * Filters: By title, release year, genre
    * Returns: List of movies with basic information
    * Caching: Movies found through TMDb are saved to local database

7. **`movies.read`** - Get detailed movie information
    * Business logic: Returns complete movie information from local database
    * Returns: Detailed movie information

8. **`movies.create`** (administrators only) - Add movie to database
    * Business rule: Only administrators can manually add movies
    * Validation: Duplicate check
    * Usage: For adding movies absent in TMDb

9. **`movies.update`** (administrators only) - Update movie information
    * Business rule: Only administrators can edit movie information
    * Usage: For correcting errors or updating data

### Special Methods

12. **`viewings.byMovie`** - Get all viewings of a specific movie by user
    * Business logic: Returns all viewing entries for one movie
    * Usage: For displaying rewatch history
    * Sorting: By viewing date

## 3. Business Rules

1. **Access Rights:**
    * Users see only their own entries
    * Administrators have access to all data for moderation
    * Guest access is forbidden - authentication required

2. **Data Validation:**
    * Rating: integer from 1 to 10
    * Viewing date: not later than current date
    * Comment: maximum 2000 characters
    * Movie title: required field when creating via API

3. **User Limitations:**
    * 60 requests per minute limit for movie search API (to protect against TMDb API abuse)
    * 100 requests per minute limit for other endpoints

4. **Working with Movies:**
    * Movies are automatically saved to local database on first search through TMDb
    * Search checks local database first, then TMDb
    * All movies are stored in local database for fast access
    * Movie information updates are only possible by administrators

## 4. Business Success Metrics

1. **API Response Speed:** 95% of requests should execute in < 500 ms
2. **Availability:** API available 99% of the time
3. **Search Accuracy:** At least 90% relevant results in first 10 search results
4. **Limitations:**
    * Regular users: 100 requests/minute
    * Administrators: no limitations