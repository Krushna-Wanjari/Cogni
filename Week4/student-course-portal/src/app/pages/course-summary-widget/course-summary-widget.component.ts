import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course.service';

// Hands-On 6, Step 62: a second consumer of CourseService, proving the root singleton is shared.
@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  imports: [CommonModule],
  template: `<p>Total courses (shared service instance): {{ (courses$ | async)?.length }}</p>`
})
export class CourseSummaryWidgetComponent {
  private courseService = inject(CourseService);
  courses$ = this.courseService.getCourses();
}
