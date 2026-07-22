import { CanDeactivateFn } from '@angular/router';
import { ReactiveEnrollmentFormComponent } from '../pages/reactive-enrollment-form/reactive-enrollment-form.component';

// Hands-On 7, Step 77: CanDeactivate guard — warns before leaving a dirty reactive form.
export const unsavedChangesGuard: CanDeactivateFn<ReactiveEnrollmentFormComponent> = (component) => {
  if (component.enrollForm?.dirty) {
    return window.confirm('You have unsaved changes. Leave?');
  }
  return true;
};
