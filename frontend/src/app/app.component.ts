import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Athena Enterprise Portal';
  
  // Connects to Java Backend via REST API
  getUserData() {
    console.log("Fetching user credentials...");
    return { user: "admin", role: "supervisor" };
  }
}
