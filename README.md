# Covered
```
1. API URI Design
   1. versioning
   2. pathvariables
   3. Query parameters
2. REST API
   1. Client and Server DTO's
   2. REST api taken RequestDto return ResponceDto
   3. Request validation
3. HTTP Status Codes
   1. Information 1XX
   2. Success 2XX
   3. Redirect 3XX
   4. Client 4XX
   5. Server 5XX
   6. Based on Request, Responce, or Exception send relavent HTTP code
4. RESTFul Principles
   1. @GetMapping
   2. @PostMapping
   3. @PutMapping
   4. @DeleteMapping
   5. @PatchMapping
5. Secure API
   1. HTTP Encrypt data
   2. OAuth2 JWT Authentication adn Authorization
   3. Validate Inputs (SQL Injections, XSS)
6. API Must support Pagination, Sorting and Filtering
   1. /users?page=1&size=10 - pagination
   2. /users?sort=username,asc - sorting
   3. /users?role=admin - filter
7. HATEOAS (Hypermedia as the Engine of Applicaton State)
   1. API may return List of Hyperlinks or URL's
   2. Better user Experience
8. Logging for better debugging and understanding code flow
   1. TRACE -for debugging.
   2. DEBUG - info for debugging.
   3. INFO - info messages highlights.
   4. WARN - harmful situations.
   5. ERROR - error events.
   6. FATAL - very server error events  app abort.
9. Request Haders
   1. Host : www.example.com
   2. Content-Type : application/json
   3. Accept: application/json
   4. Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
   5. Cache-Control: no-cache
   6. User-Agent: Mozilla/5.0
   7. Accept-Language: en-US
10.
```
