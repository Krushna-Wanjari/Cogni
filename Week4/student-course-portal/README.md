# Student Course Portal — Digital Nurture 5.0 Angular (v20.0) Solutions

Solutions for all 10 hands-on exercises in the Digital Nurture 5.0 Angular Hands-On Exercise Book.
Built as a single incremental Angular (standalone components) SPA — every hands-on adds a layer to
the same `student-course-portal` project, matching the exercise book's instructions.

## What's implemented, per hands-on

| Hands-On | Topic | Where to look |
|---|---|---|
| 1 | Project setup, first components | `src/app/components/header`, `src/app/pages/home` |
| 2 | Binding, lifecycle hooks, @Input/@Output | `home.component.ts`, `course-card.component.ts` |
| 3 | Directives & pipes | `directives/highlight.directive.ts`, `pipes/credit-label.pipe.ts` |
| 4 | Template-driven forms | `pages/enrollment-form` |
| 5 | Reactive forms, FormArray, custom/async validators | `pages/reactive-enrollment-form` |
| 6 | Services & DI | `services/course.service.ts`, `services/enrollment.service.ts`, `pages/notification` |
| 7 | Routing, guards, lazy loading | `app.routes.ts`, `features/enrollment.routes.ts`, `guards/` |
| 8 | HttpClient, RxJS operators, interceptors | `services/course.service.ts`, `interceptors/` |
| 9 | NgRx store, actions, reducers, effects, selectors | `store/course`, `store/enrollment` |
| 10 | Unit testing — Jasmine/Karma/TestBed | `*.spec.ts` files throughout |

## Setup

```bash
npm install
npm install -g json-server   # mock REST API used by Hands-On 8+

# Terminal 1: mock backend (courses/students/enrollments)
json-server --watch db.json --port 3000

# Terminal 2: Angular dev server
npm start
```

App runs at http://localhost:4200, API at http://localhost:3000.

## Testing

```bash
npm test                 # Karma + Jasmine, watch mode
ng test --code-coverage  # generates coverage/ report
```

## Notes

- Uses Angular 20 standalone components throughout (no NgModules) — `app.config.ts` replaces
  `app.module.ts`, `provideRouter`/`provideHttpClient`/`provideStore` wire everything up.
- `/enroll` is lazy-loaded (`features/enrollment.routes.ts`) and protected by `authGuard`;
  the reactive form route is additionally protected by `unsavedChangesGuard`.
- NgRx DevTools are enabled (`provideStoreDevtools`) — install the Redux DevTools Chrome
  extension to inspect the action → effect → reducer → selector flow described in Hands-On 9.
