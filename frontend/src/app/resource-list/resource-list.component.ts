import { Component, OnInit } from '@angular/core';

// Evidence of "Angular utilizing JavaScript"
@Component({
  selector: 'app-resource-list',
  templateUrl: './resource-list.component.html',
  styleUrls: ['./resource-list.component.css']
})
public class ResourceListComponent implements OnInit {
  resources = [
    { name: 'Server-Alpha', type: 'Compute', status: 'Active' },
    { name: 'DB-Beta', type: 'Database', status: 'Migrating' }
  ];

  constructor() { }

  ngOnInit(): void {
    // In a real app, this would call the Java REST API
    console.log('Fetching multi-tenant resources...');
  }
}
