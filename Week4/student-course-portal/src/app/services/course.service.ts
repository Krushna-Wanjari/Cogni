import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, retry, tap } from 'rxjs/operators';
import { Course } from '../models/course.model';

const API_URL = 'http://localhost:3000/courses';

// Hands-On 6, Task 1 (Steps 58-61) + Hands-On 8 (Steps 78-87): singleton service, now backed by HttpClient.
@Injectable({ providedIn: 'root' })
export class CourseService {
  private http = inject(HttpClient);

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(API_URL).pipe(
      map((courses) => courses.filter((c) => c.credits > 0)), // Step 83: map
      tap((courses) => console.log('Courses loaded:', courses.length)), // Step 85: tap for logging side-effect only
      retry(2), // Step 86: retry twice before failing
      catchError((err) => {
        console.error(err);
        return throwError(() => new Error('Failed to load courses. Please try again.')); // Step 84
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${API_URL}/${id}`).pipe(
      catchError((err) => {
        console.error(err);
        return throwError(() => new Error('Failed to load course.'));
      })
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(API_URL, course);
  }

  updateCourse(id: number, course: Partial<Course>): Observable<Course> {
    return this.http.put<Course>(`${API_URL}/${id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${API_URL}/${id}`);
  }
}
