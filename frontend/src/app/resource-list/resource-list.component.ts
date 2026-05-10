import { Component, OnInit } from '@angular/core';
import { Resource } from '../resource.model';
import { ResourceService } from '../resource.service';

@Component({
  selector: 'app-resource-list',
  templateUrl: './resource-list.component.html',
  styleUrls: ['./resource-list.component.css']
})
export class ResourceListComponent implements OnInit {
  resources: Resource[] = [];
  loading = true;
  error: string | null = null;

  constructor(private readonly service: ResourceService) {}

  ngOnInit(): void {
    this.service.list().subscribe({
      next: (data) => {
        this.resources = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = `Unable to load resources: ${err.message ?? err.statusText ?? 'unknown error'}`;
        this.loading = false;
      }
    });
  }
}
