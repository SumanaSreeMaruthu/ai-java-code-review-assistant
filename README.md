# Java Code Review

Java 21 / Spring Boot portfolio demonstration.

## Implemented
- Persistent H2/JPA records
- REST create, list, get, delete endpoints at `/api/v1/reviews`
- Browser interface at `http://localhost:8080/`
- Input validation, Dockerfile, basic context test and CI workflow

## Run
```bash
mvn spring-boot:run
mvn test
```

## Limitations
Static heuristic only; no LLM integration yet. This is **not** a production-ready end-to-end system. No React frontend, security, Kafka, Gemini, GitHub API integration or comprehensive integration tests have been implemented. Build has not been independently verified. Use only synthetic input.
