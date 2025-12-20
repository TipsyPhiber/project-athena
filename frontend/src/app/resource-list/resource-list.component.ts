import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-resource-list',
  templateUrl: './resource-list.component.html',
  styleUrls: ['./resource-list.component.css']
})
export class ResourceListComponent implements OnInit {
  resources = [
    { name: 'Server-Alpha', type: 'Compute', status: 'Active' },
    { name: 'DB-Beta', type: 'Database', status: 'Migrating' }
  ];

  constructor() { }

  ngOnInit(): void {
    console.log('Fetching multi-tenant resources...');
  }
}
