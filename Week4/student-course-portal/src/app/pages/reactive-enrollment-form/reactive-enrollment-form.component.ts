import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  Validators
} from '@angular/forms';
import { Observable, of } from 'rxjs';
import { delay, map } from 'rxjs/operators';

// Hands-On 5: reactive form built with FormBuilder, a custom sync validator, an async validator,
// and a FormArray of dynamically added course controls.
@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrl: './reactive-enrollment-form.component.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;

  private fb = inject(FormBuilder);

  ngOnInit(): void {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: this.fb.control('', [Validators.required, Validators.email], [this.simulateEmailCheck]),
      courseId: [null, [Validators.required, this.noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // Step 53: custom synchronous validator — rejects course codes starting with 'XX'.
  noCourseCode(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    if (typeof value === 'string' && value.toUpperCase().startsWith('XX')) {
      return { noCourseCode: true };
    }
    return null;
  }

  // Step 55: async validator — simulates a server check that rejects emails containing 'test@'.
  simulateEmailCheck(control: AbstractControl): Observable<ValidationErrors | null> {
    return of(control.value).pipe(
      delay(800),
      map((value: string) => (value?.includes('test@') ? { emailTaken: true } : null))
    );
  }

  // Step 57: typed getter avoids repeated casting in the template.
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse(): void {
    this.additionalCourses.push(this.fb.control('', Validators.required));
  }

  removeCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    console.log('value (excludes disabled controls):', this.enrollForm.value);
    console.log('getRawValue (includes all controls):', this.enrollForm.getRawValue());
  }
}
