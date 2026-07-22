import { Injectable } from '@angular/core';

// Hands-On 7, Step 75: minimal auth state used by the auth guard.
@Injectable({ providedIn: 'root' })
export class AuthService {
  isLoggedIn = true; // hardcoded for the exercise
}
