import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

// Hands-On 6, Step 67: providers: [NotificationService] creates a new instance scoped to THIS
// component (and its children) rather than sharing the app-wide root instance.
@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  providers: [NotificationService],
  template: `<div class="toast" *ngIf="notificationService.message$ | async as msg">{{ msg }}</div>`,
  styles: [`.toast { background: #2b6cb0; color: #fff; padding: 0.5rem 1rem; text-align: center; }`]
})
export class NotificationComponent {
  constructor(public notificationService: NotificationService) {}
}
