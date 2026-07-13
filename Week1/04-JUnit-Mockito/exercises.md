# JUnit 5 & Mockito — Exercises

You're given a small, already-working "business layer": `OrderRepository` (interface,
pretend DB access), `NotificationService` (interface, pretend email/SMS sender), and
`OrderService` (the class that actually needs testing — it depends on both).

Your job: write the tests in `src/test/java/.../OrderServiceTest.java`. The `// TODO`
markers tell you exactly what to write. `OrderService` itself is already complete —
don't need to touch it, just test it.

## What you're practicing
1. **Plain JUnit 5 tests** — `@Test`, `assertEquals`, `assertThrows`, `assertTrue`.
2. **Mockito mocking** — `@Mock`, `@InjectMocks`, `when(...).thenReturn(...)`.
3. **Verifying interactions** — `verify(mock).method(...)`, `verify(mock, times(n))`.
4. **Argument matchers** — `any()`, `eq()`.
5. **Exception testing** — asserting a method throws when it should.

## Tasks (see TODOs in OrderServiceTest.java)
1. `placeOrder` returns a valid order ID when stock is sufficient — verify the
   returned id and that `repository.save(...)` was called exactly once.
2. `placeOrder` throws `IllegalStateException` when stock is insufficient — and
   verify `repository.save(...)` was **never** called (order must not be persisted).
3. `placeOrder` triggers a notification via `notificationService.sendConfirmation(...)`
   — verify it was called with the right customer email.
4. `cancelOrder` returns `false` when the order doesn't exist (repository returns
   `Optional.empty()`).
5. `cancelOrder` returns `true` and calls `repository.delete(...)` when the order exists.

## Run it
```bash
mvn test
```

## Why this shape
This mirrors the exact pattern Cognizant's assessment round tests: a Service class with
injected dependencies, mock the dependencies, assert on both return values AND on
side-effect calls (verify). That combination — assert + verify — is the part people
usually forget under time pressure.
