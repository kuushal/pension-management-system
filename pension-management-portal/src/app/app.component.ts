import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthenticationService } from './service/authentication.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class AppComponent implements OnInit {
  title = 'PensionManagementPortal';
  constructor(public loginService: AuthenticationService) {}
  ngOnInit() {}
}
