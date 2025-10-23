# Test Scenarios for Vulpecula

## FR-001: Adding a Viewing Entry

| | |
|---|---|
| **Test ID** | T-001 |
| **Requirement** | FR-001 |
| **Scenario** | Adding a new movie viewing entry with rating and comment |
| **Preconditions** | 1. User is authenticated<br>2. Movie "The Shawshank Redemption" exists in the database |
| **Test Steps** | **Given:** User opened the add entry form<br>**When:** Fields are filled:<br>- Movie: "The Shawshank Redemption"<br>- Viewing Date: "2025-10-15"<br>- Rating: 9<br>- Comment: "Amazing film about hope"<br>**And:** "Save" button is pressed<br>**Then:**<br>- Entry successfully created<br>- Status 201 returned<br>- Entry is displayed in user's viewing list |
| **Test Data** | userId: "user:12345"<br>movieId: "movie:tt0111161"<br>Rating: 9/10 |
| **Pass Criteria** | 1. Entry created in database<br>2. All fields saved correctly<br>3. API response time < 500 ms |
| **Environment** | DEV (PostgreSQL) |

## FR-002: Editing a Viewing Entry

| | |
|---|---|
| **Test ID** | T-002 |
| **Requirement** | FR-002 |
| **Scenario** | Changing rating and comment of an existing entry |
| **Preconditions** | 1. User is authenticated<br>2. Entry with id="550e8400-e29b-41d4-a716-446655440000" exists |
| **Test Steps** | **Given:** User opened entry for editing<br>**When:** Fields are changed:<br>- Rating: 9 → 10<br>- Comment: "After rewatching, I appreciate it even more"<br>**And:** "Update" button is pressed<br>**Then:**<br>- Entry is updated<br>- Status 200 returned<br>- updatedAt field is updated<br>- Changes are displayed in the list |
| **Test Data** | entryId: "550e8400-e29b-41d4-a716-446655440000"<br>New rating: 10/10 |
| **Pass Criteria** | 1. Only specified fields changed<br>2. userId and movieId remained unchanged<br>3. API response time < 500 ms |
| **Environment** | STAGING |

## FR-003: Deleting a Viewing Entry

| | |
|---|---|
| **Test ID** | T-003 |
| **Requirement** | FR-003 |
| **Scenario** | Deleting an entry from the diary |
| **Preconditions** | 1. User is authenticated<br>2. Entry belonging to the user exists |
| **Test Steps** | **Given:** User selected entry for deletion<br>**When:** Deletion is confirmed<br>**Then:**<br>- Entry is deleted from database<br>- Status 204 returned<br>- Entry is not displayed in viewing list |
| **Test Data** | entryId: "550e8400-e29b-41d4-a716-446655440000"<br>userId: "user:12345" |
| **Pass Criteria** | 1. Entry is physically deleted from DB<br>2. Attempting to get entry returns 404<br>3. API response time < 500 ms |
| **Environment** | DEV |

## FR-004: Multiple Viewings of the Same Movie

| | |
|---|---|
| **Test ID** | T-004 |
| **Requirement** | FR-004 |
| **Scenario** | Adding multiple entries for one movie (rewatches) |
| **Preconditions** | 1. User is authenticated<br>2. One entry for viewing "Inception" already exists |
| **Test Steps** | **Given:** User wants to add a rewatch<br>**When:** New entry is created:<br>- Movie: "Inception" (same movieId)<br>- Viewing Date: "2025-10-20"<br>- Rating: 10<br>- Comment: "Second time - even better!"<br>**Then:**<br>- Entry successfully created<br>- Two entries for one movie in the list<br>- Both entries differ by id and date |
| **Test Data** | movieId: "movie:tt1375666"<br>First viewing: 2025-09-15, rating 9<br>Second viewing: 2025-10-20, rating 10 |
| **Pass Criteria** | 1. System allows creating multiple entries for one movie<br>2. Each entry has unique id<br>3. viewings.byMovie method returns both entries |
| **Environment** | DEV |

## FR-005: Movie Search via TMDb

| | |
|---|---|
| **Test ID** | T-005 |
| **Requirement** | FR-005 |
| **Scenario** | Searching for a movie not in local database via TMDb API |
| **Preconditions** | 1. Movie "Oppenheimer" is absent in local database<br>2. TMDb API is available |
| **Test Steps** | **Given:** User enters "Oppenheimer" in search<br>**When:** System doesn't find movie in local database<br>**Then:**<br>- Request to TMDb API is executed<br>- Movie is found and saved to local database<br>- Data returned:<br>  • Title: "Oppenheimer"<br>  • Year: 2023<br>  • Director: "Christopher Nolan"<br>  • tmdbId is saved |
| **Test Data** | Query: "Oppenheimer"<br>TMDb ID: "872585" |
| **Pass Criteria** | 1. Movie saved to local database<br>2. On repeated search, no TMDb request is made<br>3. First search time < 2 sec<br>4. Repeated search time < 500 ms |
| **Environment** | STAGING (with real TMDb API) |

## FR-006: Getting Entry List with Filtering

| | |
|---|---|
| **Test ID** | T-006 |
| **Requirement** | FR-006 |
| **Scenario** | Getting user's entry list with date and rating filtering |
| **Preconditions** | 1. User is authenticated<br>2. Database contains 20 user entries from 2025-01-01 to 2025-10-20 |
| **Test Steps** | **Given:** User requests their entry list<br>**When:** Filters applied:<br>- Date: from 2025-10-01 to 2025-10-20<br>- Rating: ≥ 8<br>**Then:**<br>- 5 entries returned<br>- All entries match filters<br>- Entries sorted by date (newest to oldest) |
| **Test Data** | userId: "user:12345"<br>Total entries: 20<br>Entries with rating ≥8 in October: 5 |
| **Pass Criteria** | 1. Only entries matching filters returned<br>2. Sorting is correct<br>3. API response time < 500 ms |
| **Environment** | STAGING |

## SEC-001: User Entry Protection

| | |
|---|---|
| **Test ID** | T-007 |
| **Requirement** | SEC-001 |
| **Scenario** | Attempt to access another user's viewing entry |
| **Preconditions** | 1. User A is authenticated (userId: "user:12345")<br>2. Entry of user B exists (userId: "user:67890") |
| **Test Steps** | **Given:** User A attempts to get user B's entry<br>**When:** viewings.read request executed with entryId belonging to user B<br>**Then:**<br>- System blocks access<br>- Status 403 Forbidden returned<br>- Access attempt logged |
| **Test Data** | User A: "user:12345"<br>User B's entry: "550e8400-e29b-41d4-a716-446655440001" |
| **Pass Criteria** | 1. Entry access denied<br>2. HTTP code 403<br>3. Attempt logged with WARN level |
| **Environment** | PROD-like |

## SEC-002: Authentication via Keycloak

| | |
|---|---|
| **Test ID** | T-008 |
| **Requirement** | SEC-002 |
| **Scenario** | Attempt to access API without authentication token |
| **Preconditions** | API endpoints require authentication |
| **Test Steps** | **Given:** User is not authenticated<br>**When:** viewings.list request executed without token<br>**Then:**<br>- System rejects request<br>- Status 401 Unauthorized returned<br>- Message: "Authentication required" |
| **Test Data** | Request without Authorization header |
| **Pass Criteria** | 1. Access denied<br>2. HTTP code 401<br>3. Data not returned |
| **Environment** | STAGING (with Keycloak) |

## PERF-001: API Performance Under Load

| | |
|---|---|
| **Test ID** | T-009 |
| **Requirement** | PERF-001 |
| **Scenario** | Checking API response time with 100 concurrent requests |
| **Preconditions** | Test environment deployed with 1000 entries in DB |
| **Test Steps** | **Given:** JMeter scenario configured:<br>- 100 virtual users<br>- Ramp-up: 10 sec<br>- Endpoint: viewings.list<br>**When:** Test is launched<br>**Then:**<br>- 95% of requests complete in ≤ 500 ms<br>- 0% errors<br>- Server CPU ≤ 70% |
| **Test Data** | 100 concurrent requests to viewings.list |
| **Pass Criteria** | 1. p95 latency ≤ 500 ms<br>2. Error rate = 0%<br>3. CPU ≤ 70%<br>4. Memory ≤ 80% |
| **Environment** | Load Testing (separate server) |

## PERF-002: Movie Search Performance

| | |
|---|---|
| **Test ID** | T-010 |
| **Requirement** | PERF-002 |
| **Scenario** | Checking movie search speed in local database |
| **Preconditions** | Database contains 10,000 movies |
| **Test Steps** | **Given:** User performs search by title<br>**When:** Query: "The"<br>**Then:**<br>- Relevant results returned<br>- Response time < 500 ms<br>- Results sorted by relevance |
| **Test Data** | Database: 10,000 movies<br>Expected results: ~500 movies with "The" in title |
| **Pass Criteria** | 1. Response time < 500 ms<br>2. Relevant results in top-10<br>3. DB indexes used |
| **Environment** | STAGING |