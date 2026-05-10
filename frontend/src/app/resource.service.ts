import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Resource } from './resource.model';

@Injectable({ providedIn: 'root' })
export class ResourceService {
  private readonly endpoint = 'http://localhost:9090/api/v1/resources';

  constructor(private http: HttpClient) {}

  list(): Observable<Resource[]> {
    return this.http.get<Resource[]>(this.endpoint);
  }

  create(resource: Resource): Observable<Resource> {
    return this.http.post<Resource>(this.endpoint, resource);
  }
}
