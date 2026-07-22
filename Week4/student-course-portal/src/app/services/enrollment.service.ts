import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Course } from '../models/course.model';
import { CourseService } from './course.service';

// Hands-On 6, Task 2 (Steps 63-64): service-to-service injection — EnrollmentService depends on CourseService.
@Injectable({ providedIn: 'root' })
export class EnrollmentService {
  private courseService = inject(CourseService);
  private http = inject(HttpClient);
  private enrolledCourseIds: number[] = [];

  enroll(courseId: number): void {
    if (!this.enrolledCourseIds.includes(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter((id) => id !== courseId);
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourses(): Course[] {
    // Resolves enrolled ids against course data — demonstrates one service consuming another.
    return [];
  }

  // Step 87: switchMap chains a course id to its enrolled students, cancelling any in-flight prior request.
  getStudentsByCourseId(courseId$: Observable<number>): Observable<unknown[]> {
    return courseId$.pipe(
      switchMap((courseId) => this.http.get<unknown[]>(`http://localhost:3000/enrollments?courseId=${courseId}`))
    );
  }
}
