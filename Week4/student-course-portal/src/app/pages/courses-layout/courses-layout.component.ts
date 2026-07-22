import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

// Hands-On 7, Step 72: parent for nested /courses routes.
@Component({
  selector: 'app-courses-layout',
  standalone: true,
  imports: [RouterOutlet],
  template: `<router-outlet></router-outlet>`
})
export class CoursesLayoutComponent {}
