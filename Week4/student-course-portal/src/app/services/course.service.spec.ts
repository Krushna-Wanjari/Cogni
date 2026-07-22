import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

// Hands-On 10, Task 2, Steps 106-108: service testing with HttpClientTestingModule.
describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS102', credits: 3, gradeStatus: 'pending' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify(); // Step 107: assert no unexpected outstanding requests
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('getCourses() should return courses from the API', () => {
    service.getCourses().subscribe((courses) => {
      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('getCourses() should propagate a friendly error on failure', () => {
    service.getCourses().subscribe({
      next: () => fail('expected an error, not courses'),
      error: (err: Error) => expect(err.message).toContain('Failed to load courses')
    });

    // retry(2) means the request fires 3 times total before catchError runs
    for (let i = 0; i < 3; i++) {
      const req = httpMock.expectOne('http://localhost:3000/courses');
      req.flush('server error', { status: 500, statusText: 'Server Error' });
    }
  });

  it('createCourse() should POST a new course', () => {
    const newCourse = { name: 'AI Basics', code: 'CS106', credits: 3, gradeStatus: 'pending' as const };
    service.createCourse(newCourse).subscribe((course) => {
      expect(course.id).toBe(6);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('POST');
    req.flush({ id: 6, ...newCourse });
  });
});
