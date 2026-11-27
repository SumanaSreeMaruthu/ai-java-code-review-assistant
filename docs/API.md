# REST API

## Domain API

- `GET /api/v1/reviews`: list records
- `GET /api/v1/reviews/{id}`: retrieve a record
- `POST /api/v1/reviews`: create a record
- `GET /api/v1/reviews/search`: repository-backed search

## Activity API

- `GET /api/v1/activity`: latest 50 events
- `GET /api/v1/activity/{resourceType}/{resourceId}`: history for a record

Creation and deletion actions are recorded in H2. This is a demonstration event history, **not** a tamper-proof security audit log. Authentication and authorization are not yet implemented.
