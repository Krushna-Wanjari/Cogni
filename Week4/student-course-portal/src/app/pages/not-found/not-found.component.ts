import { Component } from '@angular/core';

// Hands-On 7, Step 68: wildcard ** route target — must stay last in the route table.
@Component({
  selector: 'app-not-found',
  standalone: true,
  template: `<h2>404 — Page Not Found</h2><p>The page you're looking for doesn't exist.</p>`
})
export class NotFoundComponent {}
