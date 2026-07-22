import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { HighlightDirective } from '../../directives/highlight.directive';
import { EnrollmentService } from '../../services/enrollment.service';

// Hands-On 2 (Steps 18-24), Hands-On 3 (Steps 27-37), Hands-On 6 (Step 65): the portal's core reusable card.
@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe, HighlightDirective],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  private enrollmentService = inject(EnrollmentService);

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('course changed', changes['course'].previousValue, '->', changes['course'].currentValue);
    }
  }

  // Step 32: getter keeps [ngClass] bindings out of the template for readability.
  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course?.credits >= 4,
      expanded: this.isExpanded
    };
  }

  get borderStyle() {
    const colors: Record<Course['gradeStatus'], string> = { passed: 'green', failed: 'red', pending: 'grey' };
    return { 'border-left-color': colors[this.course?.gradeStatus] ?? 'grey' };
  }

  get isEnrolled(): boolean {
    return this.enrollmentService.isEnrolled(this.course?.id);
  }

  toggleExpanded(): void {
    this.isExpanded = !this.isExpanded;
  }

  onEnrollClick(): void {
    this.enrollmentService.enroll(this.course.id);
    this.enrollRequested.emit(this.course.id);
  }
}
