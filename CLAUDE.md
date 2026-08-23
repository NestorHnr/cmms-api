# CLAUDE.md

## Project Context
**CMMS API** — REST API for industrial asset maintenance management.

Domain: tracks physical assets (`Activo`) and the work orders (`OrdenDeTrabajo`) 
created to maintain them. Each work order has an SLA deadline that only counts 
down during business hours, and moves through a defined state machine 
(e.g. OPEN → IN_PROGRESS → CLOSED) rather than arbitrary transitions.

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Security 6 (JWT) — never use deprecated `WebSecurityConfigurerAdapter`
- SQL Server
- Maven
- JUnit 5 + Mockito

## Architecture Rules
- Layered structure: Controller → Service → Repository → Entity, with DTOs 
  for request/response (never expose JPA entities directly in the API).
- Constructor injection only — never field injection (`@Autowired` on a field).
- Business logic lives in the Service layer, never in the Controller.
- Global exception handling via `@RestControllerAdvice` + `@ExceptionHandler` 
  — never let raw exceptions/stack traces reach the client.
- Input validation with `@Valid` + Bean Validation annotations on DTOs.

## Domain Rules (CMMS)
- Work order state machine (general idea for now, will refine as the domain 
  model matures): OPEN → IN_PROGRESS → CLOSED. Transitions must go through 
  defined states only — no arbitrary status jumps.
- Business hours (used for SLA countdown) are NOT hardcoded. Each client 
  organization defines its own working schedule, so this must be configurable 
  data (e.g. a business-hours config/entity), not a fixed constant in code.
- The SLA timer counts only during the configured business hours — time 
  outside that window doesn't count toward the deadline.