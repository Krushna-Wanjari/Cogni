import { Routes } from '@angular/router';
import { EnrollmentFormComponent } from '../pages/enrollment-form/enrollment-form.component';
import { ReactiveEnrollmentFormComponent } from '../pages/reactive-enrollment-form/reactive-enrollment-form.component';
import { unsavedChangesGuard } from '../guards/unsaved-changes.guard';

// Hands-On 7, Step 73: lazy-loaded route group — this chunk downloads only when /enroll is visited.
export const ENROLLMENT_ROUTES: Routes = [
  { path: '', component: EnrollmentFormComponent },
  { path: 'reactive', component: ReactiveEnrollmentFormComponent, canDeactivate: [unsavedChangesGuard] }
];
