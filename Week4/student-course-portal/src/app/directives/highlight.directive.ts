import { Directive, ElementRef, HostListener, Input, inject } from '@angular/core';

// Hands-On 3, Task 3, Steps 33 & 37: custom attribute directive with a configurable colour.
@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  @Input() appHighlight = 'yellow';

  private el = inject(ElementRef<HTMLElement>);

  @HostListener('mouseenter')
  onMouseEnter(): void {
    this.el.nativeElement.style.backgroundColor = this.appHighlight;
  }

  @HostListener('mouseleave')
  onMouseLeave(): void {
    this.el.nativeElement.style.backgroundColor = '';
  }
}
