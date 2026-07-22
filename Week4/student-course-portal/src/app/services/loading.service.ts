import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

// Hands-On 8, Step 91: shared loading state driven by the loading interceptor.
@Injectable({ providedIn: 'root' })
export class LoadingService {
  private loadingSubject = new BehaviorSubject<boolean>(false);
  isLoading$ = this.loadingSubject.asObservable();

  setLoading(isLoading: boolean): void {
    this.loadingSubject.next(isLoading);
  }
}
