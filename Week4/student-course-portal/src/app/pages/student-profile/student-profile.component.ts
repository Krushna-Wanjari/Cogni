import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';

// Hands-On 6, Step 66: displays enrolled courses (now sourced from the NgRx store, Hands-On 9).
@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.component.html'
})
export class StudentProfileComponent {
  private store = inject(Store);
  enrolledCourses$ = this.store.select(selectEnrolledCourses);
}
