import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

// Hands-On 6, Step 67: provided at COMPONENT level (see NotificationComponent) rather than root,
// so each component that provides it gets its own isolated instance/state.
@Injectable()
export class NotificationService {
  private messageSubject = new BehaviorSubject<string | null>(null);
  message$ = this.messageSubject.asObservable();

  show(message: string): void {
    this.messageSubject.next(message);
    setTimeout(() => this.messageSubject.next(null), 4000);
  }
}
